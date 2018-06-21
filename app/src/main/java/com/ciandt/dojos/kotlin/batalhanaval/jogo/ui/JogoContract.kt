package com.ciandt.dojos.kotlin.batalhanaval.jogo.ui

import com.ciandt.dojos.kotlin.batalhanaval.shared.Posicao

interface JogoContract {
    interface Presenter {
        fun setView(view: View?)
        fun jogar(indiceLinha: Int, indiceColuna: Int)
    }

    interface View {
        fun showAcertou(posicao: Posicao)
        fun showAgua(posicao: Posicao)
        fun showAfundou(posicoes: List<Posicao>)
        fun showPerdeu()
        fun showGanhou()
        fun showAguarde()
        fun hideAguarde()
    }
}