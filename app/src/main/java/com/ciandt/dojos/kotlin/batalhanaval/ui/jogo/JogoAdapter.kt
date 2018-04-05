package com.ciandt.dojos.kotlin.batalhanaval.ui.jogo

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.ciandt.dojos.kotlin.batalhanaval.R
import com.ciandt.dojos.kotlin.batalhanaval.data.Posicao

/**
 * Author: andrech
 * Date: 21/02/18
 */
class JogoAdapter(private val tamanhoTabuleiro: Int, private val listener: OnItemClickListener? = null) : RecyclerView.Adapter<JogoViewHolder>(),
        JogoViewHolder.OnItemClickListener {

    private val quantidadeCelulas: Int
    private val posicoesMarcadas: MutableSet<Int> = mutableSetOf()

    init {
        quantidadeCelulas = Math.pow(tamanhoTabuleiro.toDouble(), 2.0).toInt()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): JogoViewHolder {
        val layout = LayoutInflater.from(parent?.context)
                .inflate(R.layout.item_tabuleiro, parent, false)
        return JogoViewHolder(layout, this)
    }

    override fun onBindViewHolder(holder: JogoViewHolder?, position: Int) {
        holder?.bind()
    }

    override fun getItemCount(): Int = quantidadeCelulas

    override fun onItemClick(position: Int) {
        listener?.let {
            val result = posicaoToLinhaColuna(position)

            it.onItemClick(result.first, result.second)
        }
    }

    fun posicaoToLinhaColuna(position: Int): Pair<Int, Int> {
        val linha = position / tamanhoTabuleiro
        val coluna = position - (tamanhoTabuleiro * linha)
        return linha to coluna
    }

    fun linhaColunaToPosicao(linha: Int, coluna:Int): Int {
        val posicao = (linha * tamanhoTabuleiro) + (coluna)
        return posicao
    }

    fun addNavio(posicoes: List<Posicao>) {

        print(posicoes)
        //todo converter pra número

    }

    interface OnItemClickListener {
        fun onItemClick(indiceLinha: Int, indiceColuna: Int)
    }
}