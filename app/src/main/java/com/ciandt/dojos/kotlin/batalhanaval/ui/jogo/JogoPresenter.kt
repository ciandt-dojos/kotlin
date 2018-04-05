package com.ciandt.dojos.kotlin.batalhanaval.ui.jogo

import android.content.Context
import android.util.Log
import com.ciandt.dojos.kotlin.batalhanaval.R
import com.ciandt.dojos.kotlin.batalhanaval.data.Jogo
import com.ciandt.dojos.kotlin.batalhanaval.data.Orientacao
import com.ciandt.dojos.kotlin.batalhanaval.data.Posicao
import com.ciandt.dojos.kotlin.batalhanaval.data.Tabuleiro
import com.ciandt.dojos.kotlin.batalhanaval.data.TabuleiroModel
import com.ciandt.dojos.kotlin.batalhanaval.data.Tipo

/**
 * Author: andrech
 * Date: 21/02/18
 */
class JogoPresenter(context: Context) : JogoContract.Presenter {
    override var view: JogoContract.View? = null

    override val tamanhoTabuleiro: Int

    private val jogo = Jogo()
    private val tabuleiroModel = TabuleiroModel()

    init {
        tamanhoTabuleiro = context.resources.getInteger(R.integer.tamanho_tabuleiro)
//        jogo.preencheTabuleiro(jogo.tabuleiro1)
    }

    override fun posicionar(indiceLinha: Int, indiceColuna: Int, tipo: Tipo, orientacao: Orientacao) {
        val adicionado = tabuleiroModel.adiciona(tipo, Posicao.fromIndice(indiceLinha, indiceColuna), orientacao)
        if (adicionado.first) {
            view?.showNavioPosition(adicionado.second)
        } else {
            view?.showPositionError()
        }
    }

    private fun criarPosicao(indiceLinha: Int, indiceColuna: Int): Posicao {
        // TODO: Deve ser criado um método mais inteligante de gerar a Posicao
        with(jogo.tabuleiro1) {
            val linha = intervaloLinha.elementAt(indiceLinha)
            val coluna = intervaloColuna.elementAt(indiceColuna)
            return Posicao(linha, coluna)
        }
    }
}