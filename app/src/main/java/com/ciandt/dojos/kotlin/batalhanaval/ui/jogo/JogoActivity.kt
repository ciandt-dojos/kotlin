package com.ciandt.dojos.kotlin.batalhanaval.ui.jogo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import com.ciandt.dojos.kotlin.batalhanaval.R
import kotlinx.android.synthetic.main.activity_tabuleiro.*
import kotlinx.android.synthetic.main.content_tabuleiro.*
import android.support.design.widget.BottomSheetBehavior
import android.widget.FrameLayout
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.item_selecao_navio.*


class JogoActivity : AppCompatActivity(), JogoContract.View, JogoAdapter.OnItemClickListener {

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

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<FrameLayout>

    private fun setupBottomSheet() {
         bottomSheetBehavior = BottomSheetBehavior.from(menuNavio)

        idConfirmar.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        }
    }

    private fun setupRecyclerView() {
        with (tabuleiroRecyclerView) {
            layoutManager = GridLayoutManager(this@JogoActivity, presenter.tamanhoTabuleiro)
            itemAnimator = DefaultItemAnimator()
            setHasFixedSize(true)
            adapter = JogoAdapter(presenter.tamanhoTabuleiro,this@JogoActivity)
        }
    }

    override fun onItemClick(indiceLinha: Int, indiceColuna: Int) {
        presenter.posicionar(indiceLinha, indiceColuna)



        // bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED)
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED)
        // bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN)
    }
}
