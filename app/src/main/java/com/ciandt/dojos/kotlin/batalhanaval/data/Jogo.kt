package com.ciandt.dojos.kotlin.batalhanaval.data

import java.util.*

class Jogo(
        val tabuleiro1: Tabuleiro = Tabuleiro(),
        val tabuleiro2: Tabuleiro = Tabuleiro()
) {

//    val tabuleiro1 = Tabuleiro()
//    val tabuleiro2 = Tabuleiro()
    var jogadorJogando = 1

    /*init{
        preencheTabuleiro(tabuleiro1)
        preencheTabuleiro(tabuleiro2)
    }*/

    fun preencheTabuleiro(tabuleiro : Tabuleiro){
        val r = Random();


        Tipo.values().forEach {
            val limite = tabuleiro.limites[it] ?: 0
            var qtdOks = 0
            var posicao : Posicao


            do {
                posicao = Posicao(tabuleiro.intervaloLinha.elementAt(r.nextInt(tabuleiro.tamanhoColuna)),
                        tabuleiro.intervaloColuna.elementAt(r.nextInt(tabuleiro.tamanhoColuna)))
                r.nextInt(tabuleiro.tamanhoColuna)

                if(tabuleiro.adiciona(it, posicao, Orientacao.Horizontal)){
                    qtdOks ++
                }

            }while(qtdOks < limite)

        }
    }

    fun jogarTudoAleatorio():Boolean{
        if (!(tabuleiro1.preenchidoTabuleiro() && tabuleiro2.preenchidoTabuleiro()))
            return false

        val r = Random()
        var posicaoJogador1 : Posicao
        var posicaoJogador2 : Posicao
        do {
            posicaoJogador1 = gerarPosicaoAleatoria(tabuleiro1)
            posicaoJogador2 = gerarPosicaoAleatoria(tabuleiro2)

            tabuleiro1.recebeJogada(posicaoJogador2)
            tabuleiro2.recebeJogada(posicaoJogador1)


        } while (tabuleiro1.existeNavio() && tabuleiro2.existeNavio())


        return true
    }

    fun jogar(posicao: Posicao) {
        if (!(tabuleiro1.preenchidoTabuleiro() && tabuleiro2.preenchidoTabuleiro()))
            return

        if (jogadorJogando == 1) {
            jogadorJogando = 2
            tabuleiro2.recebeJogada(posicao)
        } else {
            jogadorJogando = 1
            tabuleiro1.recebeJogada(posicao)
        }
    }

    fun gerarPosicaoAleatoria(tabuleiro: Tabuleiro) : Posicao {
        val r = Random()
        return Posicao(tabuleiro.intervaloLinha.elementAt(r.nextInt(tabuleiro.tamanhoColuna)),
                tabuleiro.intervaloColuna.elementAt(r.nextInt(tabuleiro.tamanhoColuna)))
    }


    fun exibirVencedor(): Int {
        if(tabuleiro1.existeNavio()){
            return 1
        } else{
            return 2
        }
    }


}