package com.ciandt.dojos

import java.util.*

enum class Tipo(val tamanho: Int) {
    Submarino(2),
    ContraTorpedeiros(3),
    NavioTanque(4),
    PortaAvioes(5)
}

enum class Status {
    Acertou,
    Afundou,
    Agua
}

enum class Orientacao {
    Vertical,
    Horizontal
}

data class Posicao(
        val linha: Char,
        val coluna: Int
)

class Tabuleiro() {

    public val intervaloLinha = 'A'..'J'
    public val intervaloColuna = 0..9
    public val tamanhoColuna : Int = intervaloColuna.count()

    public val limites = hashMapOf(Tipo.PortaAvioes to 1,
            Tipo.Submarino to 4, Tipo.ContraTorpedeiros to 3,
            Tipo.NavioTanque to 2)



    val listaNavios= mutableListOf<Navio>()

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

    fun recebeJogada(posicao : Posicao) : Status{

        var navio =  listaNavios.firstOrNull {
            it.posicoes.contains(posicao)
        }

        if(navio != null) {
            navio.posicoes.remove(posicao)

            if(navio.posicoes.count() > 0)
                return Status.Acertou
            else
                return Status.Afundou
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

class Jogo(){

    val tabuleiro1 = Tabuleiro()
    val tabuleiro2 = Tabuleiro()

    init{
        preencheTabuleiro(tabuleiro1)
        preencheTabuleiro(tabuleiro2)
    }

    fun preencheTabuleiro(tabuleiro : Tabuleiro){
        val r = Random();


        Tipo.values().forEach {
            val limite = tabuleiro.limites[it] ?: 0
            var qtdOks = 0
            var posicao : Posicao


            do {
                posicao = Posicao(tabuleiro.intervaloLinha.elementAt(r.nextInt(tabuleiro.tamanhoColuna)),
                        tabuleiro.intervaloColuna.elementAt(r.nextInt(tabuleiro.tamanhoColuna)))
                r.nextInt(tabuleiro.tamanhoColuna)

                if(tabuleiro.adiciona(it, posicao, Orientacao.Horizontal)){
                    qtdOks ++
                }

            }while(qtdOks < limite)

        }
    }

    fun jogar():Boolean{
        if (!(tabuleiro1.preenchidoTabuleiro() && tabuleiro2.preenchidoTabuleiro()))
            return false
        val r = Random();
        var posicaoJogador1 : Posicao
        var posicaoJogador2 : Posicao
        do {
            posicaoJogador1 = Posicao(tabuleiro1.intervaloLinha.elementAt(r.nextInt(tabuleiro1.tamanhoColuna)),
                    tabuleiro1.intervaloColuna.elementAt(r.nextInt(tabuleiro1.tamanhoColuna)))
            r.nextInt(tabuleiro1.tamanhoColuna)

            posicaoJogador2 = Posicao(tabuleiro2.intervaloLinha.elementAt(r.nextInt(tabuleiro2.tamanhoColuna)),
                    tabuleiro2.intervaloColuna.elementAt(r.nextInt(tabuleiro2.tamanhoColuna)))
            r.nextInt(tabuleiro2.tamanhoColuna)



        }while (tabuleiro1.recebeJogada(posicaoJogador1) != Status.Afundou)


    }


}