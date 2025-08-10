package chap11

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    println("${Thread.currentThread().name}: 1")
    launch {
        println("${Thread.currentThread().name}: 2")
    }
    println("${Thread.currentThread().name}: 3")
}
