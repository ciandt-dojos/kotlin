package com.ciandt.dojos

enum class Tipo(val tamanho: Int) {
    Submarino(2),
    ContraTorpedeiros(3),
    NavioTanque(4),
    PortaAvioes(5)
}

enum class Orientacao {
    Vertical,
    Horizontal
}

data class Posição(
        val linha: Char,
        val coluna: Int
)

class Tabuleiro() {

    private val intervaloLinha = 'A'..'J'
    private val intervaloColuna = 0..9

    private val limites = hashMapOf(Tipo.PortaAvioes to 1,
            Tipo.Submarino to 4, Tipo.ContraTorpedeiros to 3,
            Tipo.NavioTanque to 2)

    val listaNavios= mutableListOf<Navio>()


    fun adiciona(tipo: Tipo, posicao: Posição, orientacao: Orientacao): Boolean {


        if (limites.containsKey(tipo) &&
                listaNavios.filter { it.tipo == tipo }.size >=
                        limites.get(tipo)!! ){

            return false

        }



        if ((!intervaloColuna.contains(posicao.coluna))
                || (!intervaloLinha.contains(posicao.linha))) {
            return false
        }

        if (orientacao == Orientacao.Horizontal) {
            if (!intervaloColuna.contains(posicao.coluna + tipo.tamanho)) {
                return false
            }

        } else {
            if (!intervaloLinha.contains(posicao.linha + tipo.tamanho)) {
                return false
            }
        }

        val navio = Navio(tipo, posicao, orientacao)

        listaNavios.forEach { n ->
            navio.posicoes.forEach { p ->
                if (n.posicoes.contains(p)) {
                    return false
                }
            }
        }



        listaNavios.add(navio)

        return true
    }
}

class Navio(val tipo: Tipo, val posição: Posição, val orientacao: Orientacao) {
    val posicoes = mutableListOf<Posição>()

    init {
        if (orientacao == Orientacao.Horizontal) {
            for (i: Int in posição.coluna..(posição.coluna + tipo.tamanho)) {
                posicoes.add(Posição(posição.linha, i))
            }
        } else {
            for (i: Char in posição.linha..(posição.linha + tipo.tamanho)) {
                posicoes.add(Posição(i, posição.coluna))
            }
        }
    }


}
