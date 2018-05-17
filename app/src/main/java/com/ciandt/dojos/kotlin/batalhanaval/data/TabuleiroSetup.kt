package com.ciandt.dojos.kotlin.batalhanaval.data

import java.util.Random

/**
 * Author: andrech
 * Date: 01/03/18
 */
class TabuleiroSetup {

    val listaNavios = mutableListOf<Navio>()
    val intervaloLinha = 'A'..'J'
    val intervaloColuna = 0..9
    val tamanhoColuna: Int = intervaloColuna.count()


    val limites = hashMapOf(Tipo.PortaAvioes to 1,
            Tipo.Submarino to 4, Tipo.ContraTorpedeiros to 3,
            Tipo.NavioTanque to 2)


    fun adiciona(tipo: Tipo, posicao: Posicao, orientacao: Orientacao): Pair<Error?, List<Posicao>> {

        if (limites.containsKey(tipo) &&
                listaNavios.filter { it.tipo == tipo }.size >=
                        limites.get(tipo)!!) {

            return Error.LimitError to emptyList()

        }

        if ((!intervaloColuna.contains(posicao.coluna))
                || (!intervaloLinha.contains(posicao.linha))) {
            return Error.PositionError to emptyList()
        }

        if (orientacao == Orientacao.Horizontal) {
            if (!intervaloColuna.contains(posicao.coluna + tipo.tamanho - 1)) {
                return Error.PositionError to emptyList()
            }

        } else {
            if (!intervaloLinha.contains(posicao.linha + tipo.tamanho)) {
                return Error.PositionError to emptyList()
            }
        }

        val navio = Navio(tipo, posicao, orientacao)

        if(checkNavioExists(navio)) {
            return Error.ConflictError to emptyList()
        }

        listaNavios.add(navio)

        return null to navio.posicoes
    }

    fun checkNavioExists(tipo: Tipo, posicao: Posicao, orientacao: Orientacao):Boolean{
        val navio = Navio(tipo, posicao, orientacao)
        return checkNavioExists(navio)
    }

    fun preenchido(): Boolean {
        limites.forEach { limite ->
            val qtdeNavios = listaNavios.filter { navio ->
                navio.tipo == limite.key

            }
                    .count()
            if (qtdeNavios < limite.value) {
                return false
            }
        }

        return true
    }

    fun removeNavioAt(posicao: Posicao): List<Posicao> {
        // tanto faz o tipo ou orientacao
        val navioGenerico = Navio(Tipo.Submarino, posicao, Orientacao.Vertical)

        val navio = getNavio(navioGenerico)

        navio?.let {
            removerNavio(it)
            return it.posicoes
        }

        return emptyList()

    }

    fun getNavio(navioGenerico : Navio) : Navio? {
        listaNavios.forEach { n ->
            navioGenerico.posicoes.forEach { p ->
                if (n.posicoes.contains(p)) {
                    return n
                }
            }
        }
        return null
    }

    fun quantidadeNavios():Map<Tipo,Pair<Int,Int>>{
        var quantidadeNavios = mutableMapOf<Tipo,Pair<Int,Int>>()

        limites.forEach { limite ->
            val qtdeNavios = listaNavios.filter { navio ->
                navio.tipo == limite.key
            }.count()

            quantidadeNavios.put(limite.key, qtdeNavios to limite.value)
        }
        return quantidadeNavios
    }

    private fun removerNavio(navio:Navio) {
        listaNavios.remove(navio)
    }

    private fun checkNavioExists(navio: Navio):Boolean{
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

            Tipo.values().forEach {
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