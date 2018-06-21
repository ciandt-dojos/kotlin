package com.ciandt.dojos.kotlin.batalhanaval

import com.ciandt.dojos.kotlin.batalhanaval.shared.TipoNavio
import org.junit.Assert
import org.junit.Test

class TabuleiroSetupTest {

    @Test
    fun testForaDoTabuleiro() {

        val tabuleiro = TabuleiroSetup()

        Assert.assertNotNull(
                tabuleiro.adiciona(
                        TipoNavio.ContraTorpedeiros,
                        Posicao('K', 2),
                        Orientacao.Horizontal
                ).first
        )
    }

    @Test
    fun testParcialmenteForaDoTabuleiro() {

        val tabuleiro = TabuleiroSetup()

        Assert.assertNotNull(
                tabuleiro.adiciona(
                        TipoNavio.PortaAvioes,
                        Posicao('A', 8),
                        Orientacao.Horizontal
                ).first
        )
    }

    @Test
    fun testAddDoisPortaAvioes() {

        val tabuleiro = TabuleiroSetup()

        Assert.assertNull(
                tabuleiro.adiciona(
                        TipoNavio.PortaAvioes,
                        Posicao('A', 0),
                        Orientacao.Vertical
                ).first
        )

        Assert.assertNotNull(
                tabuleiro.adiciona(
                        TipoNavio.PortaAvioes,
                        Posicao('A', 1),
                        Orientacao.Vertical
                ).first
        )
    }

    @Test
    fun testAddNavio() {

        val tabuleiro = TabuleiroSetup()

        Assert.assertNull(
                tabuleiro.adiciona(
                        TipoNavio.PortaAvioes,
                        Posicao('A', 0),
                        Orientacao.Vertical
                ).first
        )

        Assert.assertNotNull(
                tabuleiro.adiciona(
                        TipoNavio.NavioTanque,
                        Posicao('A', 0),
                        Orientacao.Vertical
                ).first
        )
    }

    @Test
    fun testTabuleiroVazio() {
        val tabuleiro = TabuleiroSetup()
        Assert.assertFalse(tabuleiro.preenchido())
    }

    @Test
    fun testInitAleatorio(){
        val tabuleiro = TabuleiroSetup.initAleatorio()
        Assert.assertTrue(tabuleiro.preenchido())
    }
}