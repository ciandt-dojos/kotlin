package com.ciandt.dojos.kotlin.batalhanaval.ui.jogo

import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.view.View
import android.widget.LinearLayout
import com.ciandt.dojos.kotlin.batalhanaval.R
import com.ciandt.dojos.kotlin.batalhanaval.data.Orientacao
import com.ciandt.dojos.kotlin.batalhanaval.data.Posicao
import com.ciandt.dojos.kotlin.batalhanaval.data.Tipo
import kotlinx.android.synthetic.main.activity_tabuleiro.*
import kotlinx.android.synthetic.main.content_tabuleiro.*
import kotlinx.android.synthetic.main.item_selecao_navio.*


class JogoActivity : AppCompatActivity(), JogoContract.View, JogoAdapter.OnItemClickListener {


    private lateinit var adapter: JogoAdapter

    override val presenter: JogoContract.Presenter by lazy {
        JogoPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabuleiro)
        setSupportActionBar(toolbar)

        setupRecyclerView()
        setupBottomSheet()
    }

    override fun onStart() {
        super.onStart()
        presenter.view = this
    }

    override fun onStop() {
        super.onStop()
        presenter.view = null
    }

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<LinearLayout>

    private var indiceLinha: Int = -1
    private var indiceColuna: Int = -1

    private fun setupBottomSheet() {
        bottomSheetBehavior = BottomSheetBehavior.from(menuNavio)

        idConfirmar.setOnClickListener {
            val tipoNavio = when (tipoNavioRadioGroup.checkedRadioButtonId) {
                R.id.idNavioTanque -> Tipo.NavioTanque
                R.id.idSubmarino -> Tipo.Submarino
                R.id.idPortaAviao -> Tipo.PortaAvioes
                R.id.idContraTorpedeiro -> Tipo.ContraTorpedeiros
                else -> throw IllegalStateException("Navio inválido")
            }

            val orientacao = when (idOrientacao.checkedRadioButtonId) {
                R.id.idHorizontal -> Orientacao.Horizontal
                R.id.idVertical -> Orientacao.Vertical
                else -> throw IllegalStateException("Orientação inválida!")
            }

            if (indiceLinha != -1 && indiceColuna != -1) {
                presenter.posicionar(indiceLinha, indiceColuna, tipoNavio, orientacao)
            }

            hideBottomSheet()
        }

        background.setOnClickListener {
            hideBottomSheet()
        }
    }

    private fun hideBottomSheet() {
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        background.visibility = View.GONE
    }

    private fun setupRecyclerView() {
        this.adapter = JogoAdapter(presenter.tamanhoTabuleiro, this@JogoActivity)
        with(tabuleiroRecyclerView) {
            layoutManager = GridLayoutManager(this@JogoActivity, presenter.tamanhoTabuleiro)
            itemAnimator = DefaultItemAnimator()
            setHasFixedSize(true)
            adapter = this@JogoActivity.adapter
        }
    }

    override fun onItemClick(indiceLinha: Int, indiceColuna: Int) {
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

    override fun showLimitError(tipo: Tipo) {
        Snackbar.make(rootLayout, getString(R.string.tabuleiro_limite_atingido,tipo.name), Snackbar.LENGTH_LONG).show()
    }

    override fun showNavioPosition(posicoes: List<Posicao>) {
        adapter.addNavio(posicoes)
    }

}
