package com.ciandt.dojos.kotlin.batalhanaval.data

class Tabuleiro() {

    public val intervaloLinha = 'A'..'J'
    public val intervaloColuna = 0..9
    public val tamanhoColuna : Int = intervaloColuna.count()

    public val limites = hashMapOf(Tipo.PortaAvioes to 1,
            Tipo.Submarino to 4, Tipo.ContraTorpedeiros to 3,
            Tipo.NavioTanque to 2)

    val listaNavios= mutableListOf<Navio>()

    fun existeNavio() = listaNavios.isNotEmpty()



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



}