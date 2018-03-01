package com.ciandt.dojos.kotlin.batalhanaval.ui.jogo

/**
 * Author: andrech
 * Date: 21/02/18
 */
interface JogoContract {

    interface Presenter {
        val tamanhoTabuleiro: Int

        fun atirar(indiceLinha: Int, indiceColuna: Int)
    }

    interface View {
        val presenter: JogoContract.Presenter
    }
}