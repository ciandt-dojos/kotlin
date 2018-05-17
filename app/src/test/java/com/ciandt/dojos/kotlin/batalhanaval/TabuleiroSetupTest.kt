package com.ciandt.dojos.kotlin.batalhanaval

import com.ciandt.dojos.kotlin.batalhanaval.data.Orientacao
import com.ciandt.dojos.kotlin.batalhanaval.data.Posicao
import com.ciandt.dojos.kotlin.batalhanaval.data.TabuleiroSetup
import com.ciandt.dojos.kotlin.batalhanaval.data.Tipo
import org.junit.Assert
import org.junit.Test

class TabuleiroSetupTest {

    @Test
    fun testForaDoTabuleiro() {

        val tabuleiro = TabuleiroSetup()

        Assert.assertNotNull(
                tabuleiro.adiciona(
                        Tipo.ContraTorpedeiros,
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
                        Tipo.PortaAvioes,
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
                        Tipo.PortaAvioes,
                        Posicao('A', 0),
                        Orientacao.Vertical
                ).first
        )

        Assert.assertNotNull(
                tabuleiro.adiciona(
                        Tipo.PortaAvioes,
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
                        Tipo.PortaAvioes,
                        Posicao('A', 0),
                        Orientacao.Vertical
                ).first
        )

        Assert.assertNotNull(
                tabuleiro.adiciona(
                        Tipo.NavioTanque,
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