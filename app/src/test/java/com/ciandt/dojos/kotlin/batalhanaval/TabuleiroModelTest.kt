package com.ciandt.dojos.kotlin.batalhanaval

import com.ciandt.dojos.kotlin.batalhanaval.data.Orientacao
import com.ciandt.dojos.kotlin.batalhanaval.data.Posicao
import com.ciandt.dojos.kotlin.batalhanaval.data.TabuleiroModel
import com.ciandt.dojos.kotlin.batalhanaval.data.Tipo
import org.junit.Assert
import org.junit.Test

class TabuleiroModelTest {

    @Test
    fun testForaDoTabuleiro() {

        val tabuleiro = TabuleiroModel()

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

        val tabuleiro = TabuleiroModel()

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

        val tabuleiro = TabuleiroModel()

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

        val tabuleiro = TabuleiroModel()

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
        val tabuleiro = TabuleiroModel()
        Assert.assertFalse(tabuleiro.preenchido())
    }

    @Test
    fun testInitAleatorio(){
        val tabuleiro = TabuleiroModel.initAleatorio()
        Assert.assertTrue(tabuleiro.preenchido())
    }
}