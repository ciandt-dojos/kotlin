package com.ciandt.dojos

object Calc {

    fun sum(a: Int, b: Int): Int {
        return a + b
    }
}


fun main(args: Array<String>) {
    println(Calc.sum(1, 2))
}