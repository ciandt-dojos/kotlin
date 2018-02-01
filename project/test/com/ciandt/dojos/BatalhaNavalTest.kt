package com.ciandt.dojos

import com.ciandt.dojos.batalhanaval.*
import org.junit.Assert
import org.junit.Test

class BatalhaNavalTest {

    @Test
    fun testForaDoTabuleiro() {

        val tabuleiro = Tabuleiro()

        Assert.assertFalse(
                tabuleiro.adiciona(
                        Tipo.ContraTorpedeiros,
                        Posicao('K', 2),
                        Orientacao.Horizontal
                )
        )
    }

    @Test
    fun testParcialmenteForaDoTabuleiro() {

        val tabuleiro = Tabuleiro()

        Assert.assertFalse(
                tabuleiro.adiciona(
                        Tipo.PortaAvioes,
                        Posicao('A', 8),
                        Orientacao.Horizontal
                )
        )
    }

    @Test
    fun testAddDoisPortaAvioes() {

        val tabuleiro = Tabuleiro()

        Assert.assertTrue(
                tabuleiro.adiciona(
                        Tipo.PortaAvioes,
                        Posicao('A', 0),
                        Orientacao.Vertical
                )
        )

        Assert.assertFalse(
                tabuleiro.adiciona(
                        Tipo.PortaAvioes,
                        Posicao('A', 1),
                        Orientacao.Vertical
                )
        )
    }

    @Test
    fun testAddNavio() {

        val tabuleiro = Tabuleiro()

        Assert.assertTrue(
                tabuleiro.adiciona(
                        Tipo.PortaAvioes,
                        Posicao('A', 0),
                        Orientacao.Vertical
                )
        )

        Assert.assertFalse(
                tabuleiro.adiciona(
                        Tipo.NavioTanque,
                        Posicao('A', 0),
                        Orientacao.Vertical
                )
        )
    }

    @Test
    fun testTabuleiroVazio() {
        val tabuleiro = Tabuleiro()
        Assert.assertFalse(tabuleiro.preenchidoTabuleiro())
    }

    @Test
    fun testExisteNavio() {
        val tabuleiro = Tabuleiro()

        tabuleiro.adiciona(Tipo.Submarino, Posicao('A', 0), Orientacao.Horizontal)

        Assert.assertTrue(tabuleiro.existeNavio())
    }

    @Test
    fun testTabuleiro1Vencedor(){

        val jogo = Jogo();
        jogo.tabuleiro1.adiciona(Tipo.PortaAvioes, Posicao('A', 3), Orientacao.Horizontal);

        Assert.assertEquals(jogo.exibirVencedor(),1);
    }

    @Test
    fun testTabuleiro2Vencedor(){

        val tabuleiro = preencheTabuleiro()

        val jogo = Jogo(tabuleiro, tabuleiro);


//        jogo.tabuleiro1.adiciona(Tipo.Submarino, Posicao('A', 3), Orientacao.Horizontal)
//        jogo.tabuleiro2.adiciona(Tipo.Submarino, Posicao('C', 1), Orientacao.Horizontal)

//        jogo.jogar(Posicao('B', 6))
//        jogo.jogar(Posicao('A', 3))
//        jogo.jogar(Posicao('B', 7))
//        jogo.jogar(Posicao('A', 4))

        jogo.jogar(Posicao('A', 0))
        jogo.jogar(Posicao('D', 2))
        jogo.jogar(Posicao('A', 1))
        jogo.jogar(Posicao('D', 2))
        jogo.jogar(Posicao('B', 0))
        jogo.jogar(Posicao('D', 2))
        jogo.jogar(Posicao('B', 1))
        jogo.jogar(Posicao('D', 2))
        jogo.jogar(Posicao('C', 0))
        jogo.jogar(Posicao('D', 2))
        jogo.jogar(Posicao('C', 1))
        jogo.jogar(Posicao('D', 2))
        jogo.jogar(Posicao('D', 0))
        jogo.jogar(Posicao('D', 2))
        jogo.jogar(Posicao('D', 1))
        jogo.jogar(Posicao('D', 2))

        jogo.jogar(Posicao('D', 2))

        jogo.jogar(Posicao('D', 2))
        jogo.jogar(Posicao('E', 0))
        jogo.jogar(Posicao('D', 2))
        jogo.jogar(Posicao('E', 1))
        jogo.jogar(Posicao('D', 2))
        jogo.jogar(Posicao('E', 2))
        jogo.jogar(Posicao('D', 2))
        jogo.jogar(Posicao('F', 0))
        jogo.jogar(Posicao('D', 2))
        jogo.jogar(Posicao('F', 1))
        jogo.jogar(Posicao('D', 2))
        jogo.jogar(Posicao('F', 2))
        jogo.jogar(Posicao('D', 2))
        jogo.jogar(Posicao('G', 0))
        jogo.jogar(Posicao('D', 2))
        jogo.jogar(Posicao('G', 1))
        jogo.jogar(Posicao('D', 2))
        jogo.jogar(Posicao('G', 2))
        jogo.jogar(Posicao('D', 2))

        jogo.jogar(Posicao('D', 2))
        jogo.jogar(Posicao('A', 4))
        jogo.jogar(Posicao('D', 2))
        jogo.jogar(Posicao('A', 5))
        jogo.jogar(Posicao('D', 2))
        jogo.jogar(Posicao('A', 6))
        jogo.jogar(Posicao('D', 2))
        jogo.jogar(Posicao('A', 7))
        jogo.jogar(Posicao('D', 2))
        jogo.jogar(Posicao('B', 4))
        jogo.jogar(Posicao('D', 2))
        jogo.jogar(Posicao('B', 5))
        jogo.jogar(Posicao('D', 2))
        jogo.jogar(Posicao('B', 6))
        jogo.jogar(Posicao('D', 2))
        jogo.jogar(Posicao('B', 7))
        jogo.jogar(Posicao('D', 2))

        jogo.jogar(Posicao('D', 2))
        jogo.jogar(Posicao('C', 4))
        jogo.jogar(Posicao('D', 2))
        jogo.jogar(Posicao('C', 5))
        jogo.jogar(Posicao('D', 2))
        jogo.jogar(Posicao('C', 6))
        jogo.jogar(Posicao('D', 2))
        jogo.jogar(Posicao('C', 7))
        jogo.jogar(Posicao('D', 2))
        jogo.jogar(Posicao('C', 8))
        jogo.jogar(Posicao('D', 2))






        Assert.assertEquals(1,jogo.exibirVencedor());
    }

    @Test
    fun testTabuleiroCheio() {

        val tabuleiro = preencheTabuleiro()
        Assert.assertTrue(tabuleiro.preenchidoTabuleiro())
    }

    fun preencheTabuleiro(): Tabuleiro {
        val tabuleiro = Tabuleiro()

        tabuleiro.adiciona(Tipo.Submarino, Posicao('A', 0), Orientacao.Horizontal)
        tabuleiro.adiciona(Tipo.Submarino, Posicao('B', 0), Orientacao.Horizontal)
        tabuleiro.adiciona(Tipo.Submarino, Posicao('C', 0), Orientacao.Horizontal)
        tabuleiro.adiciona(Tipo.Submarino, Posicao('D', 0), Orientacao.Horizontal)

        tabuleiro.adiciona(Tipo.ContraTorpedeiros, Posicao('E', 0), Orientacao.Horizontal)
        tabuleiro.adiciona(Tipo.ContraTorpedeiros, Posicao('F', 0), Orientacao.Horizontal)
        tabuleiro.adiciona(Tipo.ContraTorpedeiros, Posicao('G', 0), Orientacao.Horizontal)

        tabuleiro.adiciona(Tipo.NavioTanque, Posicao('A', 4), Orientacao.Horizontal)
        tabuleiro.adiciona(Tipo.NavioTanque, Posicao('B', 4), Orientacao.Horizontal)

        tabuleiro.adiciona(Tipo.PortaAvioes, Posicao('C', 4), Orientacao.Horizontal)
        return tabuleiro
    }
}

