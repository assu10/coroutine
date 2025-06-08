package chap09

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    delayAndPrint()
    delayAndPrint()
}

suspend fun delayAndPrint() {
    delay(1000L)
    println("[${Thread.currentThread().name}] Hello world!")
}