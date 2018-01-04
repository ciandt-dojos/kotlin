package com.ciandt.dojos

import org.junit.Assert
import org.junit.Test
import java.util.LinkedHashMap

class  Dragao100CabecasTest
{

    @Test
    fun semRegras(){
        val dueloTeste = Duelo()
        Assert.assertEquals(-1, dueloTeste.jogar())
    }

    @Test
    fun duelo1(){
        val dueloTeste = Duelo(mapOf(7 to 10,
                11 to 16,
                15 to 11))

        Assert.assertEquals(24, dueloTeste.jogar())
    }

    @Test
    fun duelo3(){
        val dueloTeste = Duelo(mapOf(20 to 10))

        Assert.assertEquals(9, dueloTeste.jogar())
    }

    @Test
    fun duelo2(){
        val actual = Duelo(mapOf(15 to 24,
                17 to 2,
                20 to 14,
                5 to 17))

        Assert.assertEquals(-1, actual.jogar())
    }
}