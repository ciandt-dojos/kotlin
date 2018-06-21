//package com.ciandt.dojos.kotlin.batalhanaval
//
//import com.ciandt.dojos.kotlin.batalhanaval.data.*
//import org.junit.Assert
//import org.junit.Test
//
//class BatalhaNavalTest {
//
//    @Test
//    fun testExisteNavio() {
//        val tabuleiro = Tabuleiro()
//
//        tabuleiro.adiciona(TipoNavio.Submarino, Posicao('A', 0), Orientacao.Horizontal)
//
//        Assert.assertTrue(tabuleiro.existeNavio())
//    }
//
//    @Test
//    fun testTabuleiro1Vencedor(){
//
//        val jogo = Jogo()
//        jogo.tabuleiro1.adiciona(TipoNavio.PortaAvioes, Posicao('A', 3), Orientacao.Horizontal);
//
//        Assert.assertEquals(jogo.exibirVencedor(),1);
//    }
//
//    @Test
//    fun testTabuleiro2Vencedor(){
//
//        val tabuleiro = preencheTabuleiro()
//
//        val jogo = Jogo(tabuleiro, tabuleiro);
//
//
////        jogo.tabuleiro1.adiciona(TipoNavio.Submarino, Posicao('A', 3), Orientacao.Horizontal)
////        jogo.tabuleiro2.adiciona(TipoNavio.Submarino, Posicao('C', 1), Orientacao.Horizontal)
//
////        jogo.jogar(Posicao('B', 6))
////        jogo.jogar(Posicao('A', 3))
////        jogo.jogar(Posicao('B', 7))
////        jogo.jogar(Posicao('A', 4))
//
//        jogo.jogar(Posicao('A', 0))
//        jogo.jogar(Posicao('D', 2))
//        jogo.jogar(Posicao('A', 1))
//        jogo.jogar(Posicao('D', 2))
//        jogo.jogar(Posicao('B', 0))
//        jogo.jogar(Posicao('D', 2))
//        jogo.jogar(Posicao('B', 1))
//        jogo.jogar(Posicao('D', 2))
//        jogo.jogar(Posicao('C', 0))
//        jogo.jogar(Posicao('D', 2))
//        jogo.jogar(Posicao('C', 1))
//        jogo.jogar(Posicao('D', 2))
//        jogo.jogar(Posicao('D', 0))
//        jogo.jogar(Posicao('D', 2))
//        jogo.jogar(Posicao('D', 1))
//        jogo.jogar(Posicao('D', 2))
//
//        jogo.jogar(Posicao('D', 2))
//
//        jogo.jogar(Posicao('D', 2))
//        jogo.jogar(Posicao('E', 0))
//        jogo.jogar(Posicao('D', 2))
//        jogo.jogar(Posicao('E', 1))
//        jogo.jogar(Posicao('D', 2))
//        jogo.jogar(Posicao('E', 2))
//        jogo.jogar(Posicao('D', 2))
//        jogo.jogar(Posicao('F', 0))
//        jogo.jogar(Posicao('D', 2))
//        jogo.jogar(Posicao('F', 1))
//        jogo.jogar(Posicao('D', 2))
//        jogo.jogar(Posicao('F', 2))
//        jogo.jogar(Posicao('D', 2))
//        jogo.jogar(Posicao('G', 0))
//        jogo.jogar(Posicao('D', 2))
//        jogo.jogar(Posicao('G', 1))
//        jogo.jogar(Posicao('D', 2))
//        jogo.jogar(Posicao('G', 2))
//        jogo.jogar(Posicao('D', 2))
//
//        jogo.jogar(Posicao('D', 2))
//        jogo.jogar(Posicao('A', 4))
//        jogo.jogar(Posicao('D', 2))
//        jogo.jogar(Posicao('A', 5))
//        jogo.jogar(Posicao('D', 2))
//        jogo.jogar(Posicao('A', 6))
//        jogo.jogar(Posicao('D', 2))
//        jogo.jogar(Posicao('A', 7))
//        jogo.jogar(Posicao('D', 2))
//        jogo.jogar(Posicao('B', 4))
//        jogo.jogar(Posicao('D', 2))
//        jogo.jogar(Posicao('B', 5))
//        jogo.jogar(Posicao('D', 2))
//        jogo.jogar(Posicao('B', 6))
//        jogo.jogar(Posicao('D', 2))
//        jogo.jogar(Posicao('B', 7))
//        jogo.jogar(Posicao('D', 2))
//
//        jogo.jogar(Posicao('D', 2))
//        jogo.jogar(Posicao('C', 4))
//        jogo.jogar(Posicao('D', 2))
//        jogo.jogar(Posicao('C', 5))
//        jogo.jogar(Posicao('D', 2))
//        jogo.jogar(Posicao('C', 6))
//        jogo.jogar(Posicao('D', 2))
//        jogo.jogar(Posicao('C', 7))
//        jogo.jogar(Posicao('D', 2))
//        jogo.jogar(Posicao('C', 8))
//        jogo.jogar(Posicao('D', 2))
//
//
//
//
//
//
//        Assert.assertEquals(1,jogo.exibirVencedor());
//    }
//
//    @Test
//    fun testTabuleiroCheio() {
//
//        val tabuleiro = preencheTabuleiro()
//        Assert.assertTrue(tabuleiro.preenchidoTabuleiro())
//    }
//
//    fun preencheTabuleiro(): Tabuleiro {
//        val tabuleiro = Tabuleiro()
//
//        tabuleiro.adiciona(TipoNavio.Submarino, Posicao('A', 0), Orientacao.Horizontal)
//        tabuleiro.adiciona(TipoNavio.Submarino, Posicao('B', 0), Orientacao.Horizontal)
//        tabuleiro.adiciona(TipoNavio.Submarino, Posicao('C', 0), Orientacao.Horizontal)
//        tabuleiro.adiciona(TipoNavio.Submarino, Posicao('D', 0), Orientacao.Horizontal)
//
//        tabuleiro.adiciona(TipoNavio.ContraTorpedeiros, Posicao('E', 0), Orientacao.Horizontal)
//        tabuleiro.adiciona(TipoNavio.ContraTorpedeiros, Posicao('F', 0), Orientacao.Horizontal)
//        tabuleiro.adiciona(TipoNavio.ContraTorpedeiros, Posicao('G', 0), Orientacao.Horizontal)
//
//        tabuleiro.adiciona(TipoNavio.NavioTanque, Posicao('A', 4), Orientacao.Horizontal)
//        tabuleiro.adiciona(TipoNavio.NavioTanque, Posicao('B', 4), Orientacao.Horizontal)
//
//        tabuleiro.adiciona(TipoNavio.PortaAvioes, Posicao('C', 4), Orientacao.Horizontal)
//        return tabuleiro
//    }
//}
//
