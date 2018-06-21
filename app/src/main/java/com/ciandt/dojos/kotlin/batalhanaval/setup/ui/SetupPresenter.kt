package com.ciandt.dojos.kotlin.batalhanaval.setup.ui

import com.ciandt.dojos.kotlin.batalhanaval.setup.data.TabuleiroSetup
import com.ciandt.dojos.kotlin.batalhanaval.shared.Orientacao
import com.ciandt.dojos.kotlin.batalhanaval.shared.Posicao
import com.ciandt.dojos.kotlin.batalhanaval.shared.Tabuleiro
import com.ciandt.dojos.kotlin.batalhanaval.shared.TipoNavio

class SetupPresenter : SetupContract.Presenter {

    private var view: SetupContract.View? = null
    private val tabuleiroSetup = TabuleiroSetup()

    override fun setView(view: SetupContract.View?) {
        this.view = view
        setNaviosDisponiveis()
    }

    override fun jogar() {
        val tabuleiro = Tabuleiro.fromTabuleiroSetup(tabuleiroSetup)
        print("tabuleiroSetup")
    }

    override fun adicionarNavio(indiceLinha: Int, indiceColuna: Int, tipoNavio: TipoNavio, orientacao: Orientacao) {
        val adicionado = tabuleiroSetup.adiciona(tipoNavio, Posicao.fromIndice(indiceLinha, indiceColuna), orientacao)
        if (adicionado.first == null) {
            view?.showNavioPosition(adicionado.second)
            setNaviosDisponiveis()
        } else {
            when (adicionado.first) {
                TabuleiroSetup.Error.PositionError -> view?.showPositionError()
                TabuleiroSetup.Error.ConflictError -> view?.showConflictError()
                TabuleiroSetup.Error.LimitError -> view?.showLimitError(tipoNavio)
            }
        }
    }

    override fun removerNavio(indiceLinha: Int, indiceColuna: Int): List<Posicao> {
        val posicoes = tabuleiroSetup.removeNavioAt(Posicao.fromIndice(indiceLinha, indiceColuna))
        setNaviosDisponiveis()
        return posicoes
    }

    private fun setNaviosDisponiveis() {
        view?.setNaviosDisponiveis(tabuleiroSetup.quantidadeNavios())
    }

}