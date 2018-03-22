package com.ciandt.dojos.kotlin.batalhanaval.data

data class Posicao(val linha: Char, val coluna: Int) {

    companion object {
        fun fromIndice(linha: Int, coluna: Int): Posicao {
            val chars = 'A'..'J'
            return Posicao(chars.elementAt(linha), coluna)
        }
    }
}