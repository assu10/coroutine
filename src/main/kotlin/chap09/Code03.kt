package chap09

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    delayAndPrint2()
    delayAndPrint2()
    println(getElapsedTime(startTime))
}

suspend fun delayAndPrint2() {
    delay(1000L)
    println("[${Thread.currentThread().name}] Hello world!")
}

fun getElapsedTime(startTime: Long): String {
    return "지난 시간: ${System.currentTimeMillis() - startTime}ms"
}