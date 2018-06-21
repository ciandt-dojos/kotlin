package com.ciandt.dojos.kotlin.batalhanaval.setup.ui

import android.content.DialogInterface
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.Snackbar
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import com.ciandt.dojos.kotlin.batalhanaval.R
import com.ciandt.dojos.kotlin.batalhanaval.shared.Orientacao
import com.ciandt.dojos.kotlin.batalhanaval.shared.Posicao
import com.ciandt.dojos.kotlin.batalhanaval.shared.TipoNavio
import kotlinx.android.synthetic.main.activity_setup.*
import kotlinx.android.synthetic.main.content_setup.*
import kotlinx.android.synthetic.main.item_selecao_navio.*


class SetupActivity : AppCompatActivity(), SetupContract.View, SetupAdapter.OnItemClickListener {

    private val presenter: SetupContract.Presenter by lazy {
        SetupPresenter()
    }

    private lateinit var adapter: SetupAdapter

    private var newGameEnabled = false

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_setup, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.new_game -> {
                presenter.jogar()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        menu?.let {
            it.findItem(R.id.new_game)?.isEnabled = newGameEnabled
        }
        return super.onPrepareOptionsMenu(menu)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setup)
        setSupportActionBar(toolbar)

        setupRecyclerView()
        setupBottomSheet()
    }

    override fun onStart() {
        super.onStart()
        presenter.setView(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.setView(null)
    }

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<LinearLayout>

    private var indiceLinha: Int = -1
    private var indiceColuna: Int = -1

    private fun setupBottomSheet() {
        bottomSheetBehavior = BottomSheetBehavior.from(menuNavio)

        idConfirmar.setOnClickListener {
            val tipoNavio = when (tipoNavioRadioGroup.checkedRadioButtonId) {
                R.id.idNavioTanque -> TipoNavio.NavioTanque
                R.id.idSubmarino -> TipoNavio.Submarino
                R.id.idPortaAviao -> TipoNavio.PortaAvioes
                R.id.idContraTorpedeiro -> TipoNavio.ContraTorpedeiros
                else -> throw IllegalStateException("Navio inválido")
            }

            val orientacao = when (idOrientacao.checkedRadioButtonId) {
                R.id.idHorizontal -> Orientacao.Horizontal
                R.id.idVertical -> Orientacao.Vertical
                else -> throw IllegalStateException("Orientação inválida!")
            }

            if (indiceLinha != -1 && indiceColuna != -1) {
                presenter.adicionarNavio(indiceLinha, indiceColuna, tipoNavio, orientacao)
            }

            hideBottomSheet()
        }

        background.setOnClickListener {
            hideBottomSheet()
        }
    }

    override fun setNaviosDisponiveis(naviosDisponiveis: Map<TipoNavio, Pair<Int, Int>>) {

        newGameEnabled = naviosDisponiveis.filterValues { it.first != it.second }.isEmpty()

        naviosDisponiveis.forEach { (tipo, pair) ->
            when (tipo) {
                TipoNavio.NavioTanque -> {
                    idNavioTanque.isEnabled = pair.first < pair.second
                    idNavioTanque.text = getString(R.string.navio_tanque, pair.first, pair.second)
                }
                TipoNavio.ContraTorpedeiros -> {
                    idContraTorpedeiro.isEnabled = pair.first < pair.second
                    idContraTorpedeiro.text = getString(R.string.contra_torpedeiro, pair.first, pair.second)
                }
                TipoNavio.Submarino -> {
                    idSubmarino.isEnabled = pair.first < pair.second
                    idSubmarino.text = getString(R.string.submarino, pair.first, pair.second)
                }

                TipoNavio.PortaAvioes -> {
                    idPortaAviao.isEnabled = pair.first < pair.second
                    idPortaAviao.text = getString(R.string.porta_aviao, pair.first, pair.second)
                }
            }
        }
    }

    private fun hideBottomSheet() {
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        background.visibility = View.GONE
    }

    private fun setupRecyclerView() {
        val tamanhoTabuleiro: Int = resources.getInteger(R.integer.tamanho_tabuleiro)
        this.adapter = SetupAdapter(tamanhoTabuleiro, this@SetupActivity)
        with(tabuleiroRecyclerView) {
            layoutManager = GridLayoutManager(this@SetupActivity, tamanhoTabuleiro)
            itemAnimator = DefaultItemAnimator()
            setHasFixedSize(true)
            adapter = this@SetupActivity.adapter
        }
    }

    override fun onItemFilledClick(indiceLinha: Int, indiceColuna: Int) {
        this.indiceLinha = indiceLinha
        this.indiceColuna = indiceColuna

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Deseja remover o navio?")

        builder.setPositiveButton("ok", DialogInterface.OnClickListener { dialogInterface, i ->
            val posicoes = presenter.removerNavio(indiceLinha, indiceColuna)
            if (posicoes.isNotEmpty()) {
                adapter.removeNavio(posicoes)

                invalidateOptionsMenu()
            }
        })

        val dialog = builder.create()

        dialog.show()
    }

    override fun onItemEmptyClick(indiceLinha: Int, indiceColuna: Int) {
        this.indiceLinha = indiceLinha
        this.indiceColuna = indiceColuna

        background.visibility = View.VISIBLE
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
    }

    override fun showPositionError() {
        Snackbar.make(rootLayout, R.string.tabuleiro_posicao_invalida, Snackbar.LENGTH_LONG).show()
    }

    override fun showConflictError() {
        Snackbar.make(rootLayout, R.string.tabuleiro_conflito_posicao, Snackbar.LENGTH_LONG).show()
    }

    override fun showLimitError(tipoNavio: TipoNavio) {
        Snackbar.make(rootLayout, getString(R.string.tabuleiro_limite_atingido, tipoNavio.name), Snackbar.LENGTH_LONG).show()
    }

    override fun showNavioPosition(posicoes: List<Posicao>) {
        adapter.addNavio(posicoes)
        invalidateOptionsMenu()
    }

}
