package com.ciandt.dojos.kotlin.batalhanaval.shared

enum class TipoNavio(val tamanho: Int) {
    Submarino(2),
    ContraTorpedeiros(3),
    NavioTanque(4),
    PortaAvioes(5)
}

data class Navio(val tipoNavio: TipoNavio, val posicao: Posicao, val orientacao: Orientacao) {
    val posicoes = mutableListOf<Posicao>()

    init {
        if (orientacao == Orientacao.Horizontal) {
            for (i: Int in posicao.coluna..(posicao.coluna + tipoNavio.tamanho - 1)) {
                posicoes.add(Posicao(posicao.linha, i))
            }
        } else {
            for (i: Char in posicao.linha..(posicao.linha + tipoNavio.tamanho - 1)) {
                posicoes.add(Posicao(i, posicao.coluna))
            }
        }
    }
}
