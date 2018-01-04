package com.ciandt.dojos

class Duelo(
        val regras: Map<Int, Int> = emptyMap<Int, Int>()) {

    var cabecas = 100
    val cabecasDelta = mutableMapOf<Int, Int>()
    var golpes = 0

    init {
        for ((cabecasCortadas, cabecasNascidas) in regras) {
            cabecasDelta[cabecasCortadas] = cabecasCortadas - cabecasNascidas
        }
    }

    fun jogar(): Int {
        if (regras.isEmpty()) {
            return -1
        }

        while (cabecas > 0 && cabecas < 1000) {
            val cortar = quantasCabecasCortar()
            if (cortar == 0) {
                return -1
            }

            if (cabecas >= cortar && cabecasDelta.containsKey(cortar)) {


                golpes++

                if (cabecas != cortar) {
                    cabecas -= cabecasDelta[cortar]!!
                } else {
                    cabecas -= cortar
                }
            }
        }

        if (cabecas <= 0) {
            return golpes
        }

        return -1
    }

    private fun quantasCabecasCortar(): Int {
        var index = 0
        var value = Int.MIN_VALUE
        for ((cortadas, delta) in cabecasDelta) {
            if (value < delta && cabecas >= cortadas) {
                index = cortadas
                value = delta
            }
        }

        return index
    }
}