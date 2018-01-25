package com.ciandt.dojos

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
    fun testTabuleiroCheio() {
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

        Assert.assertTrue(tabuleiro.preenchidoTabuleiro())
    }
}

