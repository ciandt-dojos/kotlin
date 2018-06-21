package com.ciandt.dojos.kotlin.batalhanaval.setup.data

import com.ciandt.dojos.kotlin.batalhanaval.shared.Navio
import com.ciandt.dojos.kotlin.batalhanaval.shared.Orientacao
import com.ciandt.dojos.kotlin.batalhanaval.shared.Posicao
import com.ciandt.dojos.kotlin.batalhanaval.shared.TipoNavio
import java.util.*

class TabuleiroSetup {

    enum class Error {
        PositionError,
        LimitError,
        ConflictError
    }

    val listaNavios = mutableListOf<Navio>()
    val intervaloLinha = 'A'..'J'
    val intervaloColuna = 0..9
    val tamanhoColuna: Int = intervaloColuna.count()


    val limites = hashMapOf(TipoNavio.PortaAvioes to 1,
            TipoNavio.Submarino to 4, TipoNavio.ContraTorpedeiros to 3,
            TipoNavio.NavioTanque to 2)


    fun adiciona(tipoNavio: TipoNavio, posicao: Posicao, orientacao: Orientacao): Pair<Error?, List<Posicao>> {

        if (limites.containsKey(tipoNavio) &&
                listaNavios.filter { it.tipoNavio == tipoNavio }.size >=
                        limites.get(tipoNavio)!!) {

            return Error.LimitError to emptyList()

        }

        if ((!intervaloColuna.contains(posicao.coluna))
                || (!intervaloLinha.contains(posicao.linha))) {
            return Error.PositionError to emptyList()
        }

        if (orientacao == Orientacao.Horizontal) {
            if (!intervaloColuna.contains(posicao.coluna + tipoNavio.tamanho - 1)) {
                return Error.PositionError to emptyList()
            }

        } else {
            if (!intervaloLinha.contains(posicao.linha + tipoNavio.tamanho)) {
                return Error.PositionError to emptyList()
            }
        }

        val navio = Navio(tipoNavio, posicao, orientacao)

        if (checkNavioExists(navio)) {
            return Error.ConflictError to emptyList()
        }

        listaNavios.add(navio)

        return null to navio.posicoes
    }

    fun checkNavioExists(tipoNavio: TipoNavio, posicao: Posicao, orientacao: Orientacao): Boolean {
        val navio = Navio(tipoNavio, posicao, orientacao)
        return checkNavioExists(navio)
    }

    fun preenchido(): Boolean {
        limites.forEach { limite ->
            val qtdeNavios = listaNavios.filter { navio ->
                navio.tipoNavio == limite.key

            }
                    .count()
            if (qtdeNavios < limite.value) {
                return false
            }
        }

        return true
    }

    fun removeNavioAt(posicao: Posicao): List<Posicao> {
        // tanto faz o tipoNavio ou orientacao
        val navioGenerico = Navio(TipoNavio.Submarino, posicao, Orientacao.Vertical)

        val navio = getNavio(navioGenerico)

        navio?.let {
            removerNavio(it)
            return it.posicoes
        }

        return emptyList()

    }

    fun getNavio(navioGenerico: Navio): Navio? {
        listaNavios.forEach { n ->
            navioGenerico.posicoes.forEach { p ->
                if (n.posicoes.contains(p)) {
                    return n
                }
            }
        }
        return null
    }

    fun quantidadeNavios(): Map<TipoNavio, Pair<Int, Int>> {
        var quantidadeNavios = mutableMapOf<TipoNavio, Pair<Int, Int>>()

        limites.forEach { limite ->
            val qtdeNavios = listaNavios.filter { navio ->
                navio.tipoNavio == limite.key
            }.count()

            quantidadeNavios.put(limite.key, qtdeNavios to limite.value)
        }
        return quantidadeNavios
    }

    private fun removerNavio(navio: Navio) {
        listaNavios.remove(navio)
    }

    private fun checkNavioExists(navio: Navio): Boolean {
        listaNavios.forEach { n ->
            navio.posicoes.forEach { p ->
                if (n.posicoes.contains(p)) {
                    return true
                }
            }
        }
        return false
    }

    companion object {
        fun initAleatorio(): TabuleiroSetup {
            val tabuleiroModel = TabuleiroSetup()
            val r = Random()

            TipoNavio.values().forEach {
                val limite = tabuleiroModel.limites[it] ?: 0
                var qtdOks = 0
                var posicao: Posicao


                do {
                    posicao = Posicao(tabuleiroModel.intervaloLinha.elementAt(r.nextInt(tabuleiroModel.tamanhoColuna)),
                            tabuleiroModel.intervaloColuna.elementAt(r.nextInt(tabuleiroModel.tamanhoColuna)))
                    r.nextInt(tabuleiroModel.tamanhoColuna)

                    if (tabuleiroModel.adiciona(it, posicao, Orientacao.Horizontal).first == null) {
                        qtdOks++
                    }

                } while (qtdOks < limite)

            }
            return tabuleiroModel
        }
    }
}