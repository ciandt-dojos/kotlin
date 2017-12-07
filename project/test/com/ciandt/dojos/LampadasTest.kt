package com.ciandt.dojos

import org.junit.Assert.assertEquals
import org.junit.Test

class LampadasTest {
    @Test
    fun acender() {
        val input = 2
        val expected = "On Off"

        assertEquals(expected, Lampadas.acender(input))
    }

    @Test
    fun acender3() {
        val input = 3
        val expected = "On Off Off"

        assertEquals(expected, Lampadas.acender(input))
    }

    @Test
    fun acender4() {
        val input = 4
        val expected = "On Off Off On"

        assertEquals(expected, Lampadas.acender(input))
    }
}