package com.ciandt.dojos.kotlin.batalhanaval.data

import java.util.*

/**
 * Author: andrech
 * Date: 01/03/18
 */
class TabuleiroModel {

    val listaNavios = mutableListOf<Navio>()
    val intervaloLinha = 'A'..'J'
    val intervaloColuna = 0..9
    val tamanhoColuna : Int = intervaloColuna.count()


    val limites = hashMapOf(Tipo.PortaAvioes to 1,
            Tipo.Submarino to 4, Tipo.ContraTorpedeiros to 3,
            Tipo.NavioTanque to 2)


    fun adiciona(tipo: Tipo, posicao: Posicao, orientacao: Orientacao): Boolean {


        if (limites.containsKey(tipo) &&
                listaNavios.filter { it.tipo == tipo }.size >=
                limites.get(tipo)!!) {

            return false

        }

        if ((!intervaloColuna.contains(posicao.coluna))
                || (!intervaloLinha.contains(posicao.linha))) {
            return false
        }

        if (orientacao == Orientacao.Horizontal) {
            if (!intervaloColuna.contains(posicao.coluna + tipo.tamanho)) {
                return false
            }

        } else {
            if (!intervaloLinha.contains(posicao.linha + tipo.tamanho)) {
                return false
            }
        }

        val navio = Navio(tipo, posicao, orientacao)

        listaNavios.forEach { n ->
            navio.posicoes.forEach { p ->
                if (n.posicoes.contains(p)) {
                    return false
                }
            }
        }



        listaNavios.add(navio)

        return true
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




    companion object {
        fun initAleatorio(): TabuleiroModel {
            val tabuleiroModel = TabuleiroModel()
            val r = Random();

            Tipo.values().forEach {
                val limite = tabuleiroModel.limites[it] ?: 0
                var qtdOks = 0
                var posicao: Posicao


                do {
                    posicao = Posicao(tabuleiroModel.intervaloLinha.elementAt(r.nextInt(tabuleiroModel.tamanhoColuna)),
                            tabuleiroModel.intervaloColuna.elementAt(r.nextInt(tabuleiroModel.tamanhoColuna)))
                    r.nextInt(tabuleiroModel.tamanhoColuna)

                    if (tabuleiroModel.adiciona(it, posicao, Orientacao.Horizontal)) {
                        qtdOks++
                    }

                } while (qtdOks < limite)

            }
            return tabuleiroModel
        }
    }
}