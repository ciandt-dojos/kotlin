package com.ciandt.dojos.kotlin.batalhanaval.ui.jogo

import com.ciandt.dojos.kotlin.batalhanaval.data.Orientacao
import com.ciandt.dojos.kotlin.batalhanaval.data.Posicao
import com.ciandt.dojos.kotlin.batalhanaval.data.Tipo

/**
 * Author: andrech
 * Date: 21/02/18
 */
interface JogoContract {

    interface Presenter {
        val tamanhoTabuleiro: Int
        var view: View?
        fun posicionar(indiceLinha: Int, indiceColuna: Int, tipo: Tipo, orientacao: Orientacao)
    }

    interface View {
        fun showPositionError()
        fun showNavioPosition(posicoes: List<Posicao>)

        val presenter: JogoContract.Presenter
    }
}