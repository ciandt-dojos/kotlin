package com.ciandt.dojos

import org.junit.Assert
import org.junit.Test


class CaixaEletronicoTest {

    @Test
    fun sacar180(){
        Assert.assertEquals(arrayListOf(100, 50, 20, 10), CaixaEletronico().sacar(180))
    }

    @Test
    fun sacar150(){
        val expected = arrayListOf(100, 50)
        Assert.assertEquals(expected, CaixaEletronico().sacar(150))
    }

    @Test
    fun sacar120(){
        val expected = arrayListOf(100, 20)
        Assert.assertEquals(expected, CaixaEletronico().sacar(120))
    }

    @Test
    fun sacar360(){
        val expected = arrayListOf(100,100, 100, 50, 10)
        val result = CaixaEletronico().sacar(360)

        print(result)

        Assert.assertEquals(expected, result)
    }

    @Test
    fun sacar360Param(){
        val expected = emptyList<Int>()
        val result = CaixaEletronico(linkedMapOf(50 to 2, 20 to 2)).sacar(360)

        print(result)

        Assert.assertEquals(expected, result)
    }

    @Test
    fun sacar120Param(){
        val expected = emptyList<Int>()
        val result = CaixaEletronico(linkedMapOf(50 to 2, 20 to 1)).sacar(120)

        print(result)

        Assert.assertEquals(expected, result)
    }

    @Test
    fun sacarAll(){

        val caixa = CaixaEletronico(linkedMapOf(100 to 1, 50 to 2, 20 to 4, 10 to 8))

        Assert.assertEquals(listOf(50, 20, 20), caixa.sacar(90))
        Assert.assertEquals(listOf(100, 20, 10), caixa.sacar(130))
        Assert.assertEquals(listOf(50, 20, 10), caixa.sacar(80))
        Assert.assertEquals(listOf(10, 10, 10, 10, 10, 10), caixa.sacar(60))
        Assert.assertEquals(emptyList<Int>(), caixa.sacar(20))
    }
}