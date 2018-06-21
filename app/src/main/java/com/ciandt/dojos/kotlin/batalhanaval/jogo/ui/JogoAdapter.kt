package com.ciandt.dojos.kotlin.batalhanaval.jogo.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.ciandt.dojos.kotlin.batalhanaval.R

class JogoAdapter(private val tamanhoTabuleiro: Int, private val listener: OnItemClickListener? = null) : RecyclerView.Adapter<JogoViewHolder>(), JogoViewHolder.OnItemClickListener {

    private val quantidadeCelulas: Int = Math.pow(tamanhoTabuleiro.toDouble(), 2.0).toInt()

    override fun onBindViewHolder(holder: JogoViewHolder?, position: Int) {
    }

    override fun getItemCount(): Int = quantidadeCelulas

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): JogoViewHolder {
        val layout = LayoutInflater.from(parent?.context).inflate(R.layout.item_tabuleiro_jogo, parent, false)
        return JogoViewHolder(layout, this)
    }

    override fun onItemClick(position: Int) {
        listener?.let {
            val result = posicaoToLinhaColuna(position)
            it.onItemEmptyClick(result.first, result.second)
        }
    }

    private fun posicaoToLinhaColuna(position: Int): Pair<Int, Int> {
        val linha = position / tamanhoTabuleiro
        val coluna = position - (tamanhoTabuleiro * linha)
        return linha to coluna
    }

    interface OnItemClickListener {
        fun onItemEmptyClick(indiceLinha: Int, indiceColuna: Int)
    }

}