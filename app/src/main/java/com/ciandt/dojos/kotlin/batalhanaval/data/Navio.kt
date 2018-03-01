package com.ciandt.dojos.kotlin.batalhanaval.data

class Navio(val tipo: Tipo, val posicao: Posicao, val orientacao: Orientacao) {
    val posicoes = mutableListOf<Posicao>()

    init {
        if (orientacao == Orientacao.Horizontal) {
            for (i: Int in posicao.coluna..(posicao.coluna + tipo.tamanho)) {
                posicoes.add(Posicao(posicao.linha, i))
            }
        } else {
            for (i: Char in posicao.linha..(posicao.linha + tipo.tamanho)) {
                posicoes.add(Posicao(i, posicao.coluna))
            }
        }
    }
}