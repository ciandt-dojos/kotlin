package com.ciandt.dojos.kotlin.batalhanaval.jogo.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.ciandt.dojos.kotlin.batalhanaval.R

class JogoAdversarioAdapter(private val tamanhoTabuleiro: Int) : RecyclerView.Adapter<JogoAdversarioViewHolder>() {

    private val quantidadeCelulas: Int = Math.pow(tamanhoTabuleiro.toDouble(), 2.0).toInt()

    override fun onBindViewHolder(holder: JogoAdversarioViewHolder?, position: Int) {
    }

    override fun getItemCount(): Int = quantidadeCelulas

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): JogoAdversarioViewHolder {
        val layout = LayoutInflater.from(parent?.context).inflate(R.layout.item_tabuleiro_jogo_adversario, parent, false)
        return JogoAdversarioViewHolder(layout)
    }
}