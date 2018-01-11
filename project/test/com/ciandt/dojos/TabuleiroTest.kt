package com.ciandt.dojos

import jogodavelha.Jogo
import jogodavelha.Status
import jogodavelha.Tabuleiro
import org.junit.Assert
import org.junit.Test

class TabuleiroTest {

    @Test
    fun marcar_sucesso(){

        var tabuleiro = Tabuleiro()

        Assert.assertEquals(true, tabuleiro.marcar("X", 0))

        //assert("X,,,,,,,,",tabuleiro.getStatus())

        Assert.assertEquals(true, tabuleiro.marcar("O", 1))
        Assert.assertEquals(false, tabuleiro.marcar("O", 0))
        Assert.assertEquals(false, tabuleiro.marcar("O", 15))
    }

    @Test
    fun valida_estado_tabuleiro(){
        var tabuleiro = Tabuleiro()

        tabuleiro.marcar("X", 0)
        tabuleiro.marcar("X", 1)
        tabuleiro.marcar("X", 2)

        val listaValida = listOf(0, 1, 2)
        Assert.assertEquals(listaValida, tabuleiro.getPosicoesJogador("X"))
    }

    @Test
    fun valida_jogo(){

        var jogo = Jogo()

        jogo.jogar("X", 0)
        jogo.jogar("X", 1)
        jogo.jogar("X", 2)

        val listaValida = listOf(0, 1, 2)

        // Validar se o jogador X venceu enum == Status.X
        Assert.assertEquals(Status.X, jogo.vencedor())
    }
}