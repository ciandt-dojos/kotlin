package com.ciandt.dojos.kotlin.batalhanaval.setup.ui

import com.ciandt.dojos.kotlin.batalhanaval.shared.Orientacao
import com.ciandt.dojos.kotlin.batalhanaval.shared.Posicao
import com.ciandt.dojos.kotlin.batalhanaval.shared.TipoNavio

interface SetupContract {

    interface Presenter {
        fun setView(view: View?)

        fun adicionarNavio(indiceLinha: Int, indiceColuna: Int, tipoNavio: TipoNavio, orientacao: Orientacao)
        fun removerNavio(indiceLinha: Int, indiceColuna: Int): List<Posicao>
        fun jogar()
    }

    interface View {
        fun setNaviosDisponiveis(naviosDisponiveis: Map<TipoNavio, Pair<Int, Int>>)
        fun showNavioPosition(posicoes: List<Posicao>)
        fun showConflictError()
        fun showPositionError()
        fun showLimitError(tipoNavio: TipoNavio)
    }
}