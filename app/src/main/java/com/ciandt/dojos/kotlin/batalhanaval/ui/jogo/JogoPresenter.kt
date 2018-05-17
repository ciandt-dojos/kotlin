package com.ciandt.dojos.kotlin.batalhanaval.ui.jogo

import android.content.Context
import com.ciandt.dojos.kotlin.batalhanaval.R
import com.ciandt.dojos.kotlin.batalhanaval.data.*

/**
 * Author: andrech
 * Date: 21/02/18
 */
class JogoPresenter(context: Context) : JogoContract.Presenter {
    override fun jogar() {
        val tabuleiro = Tabuleiro.buildTabuleiro(tabuleiroModel)
        print("tabule")
    }

    override fun checkNavioExists(indiceLinha: Int, indiceColuna: Int, tipo: Tipo): Boolean {
        return tabuleiroModel.checkNavioExists(tipo,Posicao.fromIndice(indiceLinha, indiceColuna), Orientacao.Vertical)
    }

    override var view: JogoContract.View? = null

    override val tamanhoTabuleiro: Int

    private val jogo = Jogo()
    private val tabuleiroModel = TabuleiroSetup()

    init {
        tamanhoTabuleiro = context.resources.getInteger(R.integer.tamanho_tabuleiro)
//        jogo.preencheTabuleiro(jogo.tabuleiro1)
    }

    override fun posicionar(indiceLinha: Int, indiceColuna: Int, tipo: Tipo, orientacao: Orientacao) {
        val adicionado = tabuleiroModel.adiciona(tipo, Posicao.fromIndice(indiceLinha, indiceColuna), orientacao)
        if (adicionado.first == null) {
            view?.showNavioPosition(adicionado.second)
        } else {
            when(adicionado.first){
                Error.PositionError -> view?.showPositionError()
                Error.ConflictError -> view?.showConflictError()
                Error.LimitError -> view?.showLimitError(tipo)
            }

        }
    }

    override fun removerNavio(indiceLinha: Int, indiceColuna: Int): List<Posicao> {
        return tabuleiroModel.removeNavioAt(Posicao.fromIndice(indiceLinha, indiceColuna))
    }

    override fun quantidadeNavios(): Map<Tipo, Pair<Int, Int>> {
        return tabuleiroModel.quantidadeNavios()
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