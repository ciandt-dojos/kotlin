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
                        Posição('K', 2),
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
                        Posição('A', 8),
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
                        Posição('A', 0),
                        Orientacao.Vertical
                )
        )

        Assert.assertFalse(
                tabuleiro.adiciona(
                        Tipo.PortaAvioes,
                        Posição('A', 1),
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
                        Posição('A', 0),
                        Orientacao.Vertical
                )
        )

        Assert.assertFalse(
                tabuleiro.adiciona(
                        Tipo.NavioTanque,
                        Posição('A', 0),
                        Orientacao.Vertical
                )
        )
    }
}

