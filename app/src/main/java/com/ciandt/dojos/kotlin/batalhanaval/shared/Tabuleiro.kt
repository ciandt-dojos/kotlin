package com.ciandt.dojos.kotlin.batalhanaval.shared

import com.ciandt.dojos.kotlin.batalhanaval.setup.data.TabuleiroSetup

class Tabuleiro() {

    public val intervaloLinha = 'A'..'J'
    public val intervaloColuna = 0..9
    public val tamanhoColuna: Int = intervaloColuna.count()

    public val limites = hashMapOf(TipoNavio.PortaAvioes to 1,
            TipoNavio.Submarino to 4, TipoNavio.ContraTorpedeiros to 3,
            TipoNavio.NavioTanque to 2)

    val listaNavios = mutableListOf<Navio>()

    fun existeNavio() = listaNavios.isNotEmpty()

    fun preenchidoTabuleiro(): Boolean {
        limites.forEach { limite ->
            val qtdeNavios = listaNavios.filter { navio ->
                navio.tipoNavio == limite.key

            }
                    .count()
            if (qtdeNavios < limite.value) {
                return false
            }
        }

        return true
    }

    fun recebeJogada(posicao: Posicao): StatusJogada {

        val navio = listaNavios.firstOrNull {
            it.posicoes.contains(posicao)
        }

        if (navio != null) {
            navio.posicoes.remove(posicao)

            if (navio.posicoes.count() > 0)
                return StatusJogada.Acertou
            else {
                listaNavios.remove(navio)
                return StatusJogada.Afundou
            }
        }

        return StatusJogada.Agua
    }

    fun adiciona(tipoNavio: TipoNavio, posicao: Posicao, orientacao: Orientacao): Boolean {


        if (limites.containsKey(tipoNavio) &&
                listaNavios.filter { it.tipoNavio == tipoNavio }.size >=
                        limites.get(tipoNavio)!!) {

            return false

        }

        if ((!intervaloColuna.contains(posicao.coluna))
                || (!intervaloLinha.contains(posicao.linha))) {
            return false
        }

        if (orientacao == Orientacao.Horizontal) {
            if (!intervaloColuna.contains(posicao.coluna + tipoNavio.tamanho)) {
                return false
            }

        } else {
            if (!intervaloLinha.contains(posicao.linha + tipoNavio.tamanho)) {
                return false
            }
        }

        val navio = Navio(tipoNavio, posicao, orientacao)

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

    companion object {
        fun fromTabuleiroSetup(tabuleiroSetup: TabuleiroSetup): Tabuleiro {
            return Tabuleiro().apply { listaNavios.addAll(tabuleiroSetup.listaNavios) }
        }
    }

}