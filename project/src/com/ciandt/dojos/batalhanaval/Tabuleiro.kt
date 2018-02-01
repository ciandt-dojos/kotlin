package com.ciandt.dojos.batalhanaval

class Tabuleiro() {

    public val intervaloLinha = 'A'..'J'
    public val intervaloColuna = 0..9
    public val tamanhoColuna : Int = intervaloColuna.count()

    public val limites = hashMapOf(Tipo.PortaAvioes to 1,
            Tipo.Submarino to 4, Tipo.ContraTorpedeiros to 3,
            Tipo.NavioTanque to 2)

    val listaNavios= mutableListOf<Navio>()

    fun existeNavio() = listaNavios.isNotEmpty()

    fun preenchidoTabuleiro() : Boolean {
        limites.forEach { limite ->
            val qtdeNavios = listaNavios.filter { navio ->
                navio.tipo == limite.key

                }
                    .count()
            if (qtdeNavios < limite.value) {
                return false
            }
        }

        return true
    }

    fun recebeJogada(posicao : Posicao) : Status {

        val navio =  listaNavios.firstOrNull {
            it.posicoes.contains(posicao)
        }

        if(navio != null) {
            navio.posicoes.remove(posicao)

            if(navio.posicoes.count() > 0)
                return Status.Acertou
            else {
                listaNavios.remove(navio)
                return Status.Afundou
            }
        }

        return Status.Agua
    }

    fun adiciona(tipo: Tipo, posicao: Posicao, orientacao: Orientacao): Boolean {


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