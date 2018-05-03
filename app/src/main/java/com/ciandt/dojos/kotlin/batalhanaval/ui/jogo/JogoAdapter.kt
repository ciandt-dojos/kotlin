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

    private val quantidadeCelulas: Int = Math.pow(tamanhoTabuleiro.toDouble(), 2.0).toInt()
    private val posicoesMarcadas: ArrayList<Posicao> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): JogoViewHolder {
        val layout = LayoutInflater.from(parent?.context)
                .inflate(R.layout.item_tabuleiro, parent, false)
        return JogoViewHolder(layout, this)
    }

    override fun onBindViewHolder(holder: JogoViewHolder?, position: Int) {
        val linhaColuna = posicaoToLinhaColuna(position)
        val p = Posicao.fromIndice(linhaColuna.first, linhaColuna.second)
        holder?.bind(posicoesMarcadas.contains(p))
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
        posicoesMarcadas.addAll(posicoes)
        notifyDataSetChanged()

    }

    interface OnItemClickListener {
        fun onItemClick(indiceLinha: Int, indiceColuna: Int)
    }
}