package com.ciandt.dojos.kotlin.batalhanaval.jogo.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import com.ciandt.dojos.kotlin.batalhanaval.R
import kotlinx.android.synthetic.main.content_setup.*

class JogoActivity : AppCompatActivity(), JogoAdapter.OnItemClickListener {

    private lateinit var adapter: JogoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jogo)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val tamanhoTabuleiro: Int = resources.getInteger(R.integer.tamanho_tabuleiro)
        this.adapter = JogoAdapter(tamanhoTabuleiro, this@JogoActivity)
        with(tabuleiroRecyclerView) {
            layoutManager = GridLayoutManager(this@JogoActivity, tamanhoTabuleiro)
            itemAnimator = DefaultItemAnimator()
            setHasFixedSize(true)
            adapter = this@JogoActivity.adapter
        }
    }

    override fun onItemEmptyClick(indiceLinha: Int, indiceColuna: Int) {
        Log.d("JogoActivity", "linha: " + indiceLinha)
        Log.d("JogoActivity", "coluna: " + indiceColuna)
    }
}
