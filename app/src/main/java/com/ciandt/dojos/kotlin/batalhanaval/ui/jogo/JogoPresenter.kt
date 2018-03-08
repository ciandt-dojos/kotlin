package com.ciandt.dojos.kotlin.batalhanaval.ui.jogo

import android.content.Context
import com.ciandt.dojos.kotlin.batalhanaval.R
import com.ciandt.dojos.kotlin.batalhanaval.data.Jogo
import com.ciandt.dojos.kotlin.batalhanaval.data.Posicao

/**
 * Author: andrech
 * Date: 21/02/18
 */
class JogoPresenter(context: Context) : JogoContract.Presenter {

    override val tamanhoTabuleiro: Int

    private val jogo = Jogo()

    init {
        tamanhoTabuleiro = context.resources.getInteger(R.integer.tamanho_tabuleiro)
//        jogo.preencheTabuleiro(jogo.tabuleiro1)
    }

    override fun posicionar(indiceLinha: Int, indiceColuna: Int) {
//        jogo.jogar(criarPosicao(indiceLinha, indiceColuna))
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