package jogodavelha

class JogoDaVelhaTabuleiro {

    var celulas = arrayOf("", "", "", "", "", "", "", "", "")


    fun marcar(simbolo: String, posicao: Int): Boolean {

        if ((posicao < celulas.count() && posicao >= 0) && celulas[posicao].isEmpty()) {
            celulas[posicao] = simbolo
            return true
        }
        return false

    }

    fun getPosicoesJogador(simbolo: String): List<Int> {
        var indices = mutableListOf<Int>()
        celulas.forEachIndexed { index, s ->
            if (s == simbolo) {
                indices.add(index)
            }
        }
        return indices;
    }
}

public enum class Status(val valor: String)
{
    O("O"), X("X"), velha("velha"), andamento("andamento")
}

class Jogo() {

    val tabuleiro = JogoDaVelhaTabuleiro()
    var status = Status.andamento

    var jogadasVencedoras = listOf(
             listOf(0,1,2)
            ,listOf(0,4,8)
            ,listOf(3,4,5)
            ,listOf(6,7,8)
            ,listOf(0,3,6)
            ,listOf(1,4,7)
            ,listOf(2,5,8)
            ,listOf(2,4,6)
    )


    fun jogar(simbolo: String, posicao: Int): Status {

        if (status == Status.andamento) {
            tabuleiro.marcar(simbolo, posicao)
        }

        jogadasVencedoras.forEach{
            if(tabuleiro.getPosicoesJogador(simbolo).containsAll(it))
                return Status.valueOf(simbolo)
        }

        jogadasVencedoras.forEach{
            if(tabuleiro.celulas.filter { it == "" }.count()==0)
                return Status.velha
        }

        return Status.andamento
    }


}