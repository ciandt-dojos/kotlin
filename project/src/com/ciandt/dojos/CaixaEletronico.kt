package com.ciandt.dojos

import java.util.LinkedHashMap

class CaixaEletronico(
        val notas: LinkedHashMap<Int, Int> = linkedMapOf(100 to 1000,
                50 to 1000,
                20 to 1000,
                10 to 1000)
) {
    fun sacar(saque: Int): List<Int> {

        if (saque <= 0 || notas.isEmpty() || saque % notas.keys.min()!! != 0 || !validarQuantidade(saque))
            return emptyList()

        var saque = saque
        val result = mutableListOf<Int>()

        for ((nota, quantidade) in notas) {

            if (saque == 0)
                break

            if (quantidade == 0)
                continue


            if (saque % nota >= 0) {

                val numDeNotas = Math.min(saque / nota, quantidade)
                notas[nota] = quantidade - numDeNotas
                result.addAll((0 until numDeNotas).map { nota })

                saque -= numDeNotas * nota
            }
        }

        return result
    }

    private fun validarQuantidade(saque: Int): Boolean {

        val total = notas.map { it.key * it.value }.sum()

        println("Value $total")

        return total >= saque
    }
}