package com.ciandt.dojos

import org.junit.Assert
import org.junit.Test


class EncontelTest {

    @Test
     fun match(){
        val input = "1-HOME-SWEET-HOME"
        val expected = "1-4663-79338-4663"
        Assert.assertEquals(expected, Encontel.findNumber(input))
    }

    @Test
    fun matchNumber(){
        val input = "1-HOME-SWEET-HOME"
        val expected = 14663793384663
        Assert.assertEquals(expected, Encontel.findNumberNumeric(input))
    }
}
