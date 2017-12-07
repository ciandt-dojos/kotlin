package com.ciandt.dojos

object Lampadas {
    fun acender(numLampadas: Int): String {
        val lampadas = mutableListOf<Boolean>()

        for(i in 0 until numLampadas){
            lampadas.add(false)
        }

        for (caminhada in 0 until numLampadas) {
            for (posLampada in 0 until numLampadas) {
                if ( (posLampada+1) % ( caminhada+1 ) == 0) {
                    lampadas[posLampada] = !lampadas[posLampada]
                }
            }
        }

        return lampadas.map { if (it)  "On" else "Off" }.joinToString(" ")
    }
}