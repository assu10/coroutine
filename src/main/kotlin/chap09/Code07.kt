package chap09

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    launch {
        delayAndPrint3()
    }
    launch {
        delayAndPrint3()
    }
    println(getElapsedTime(startTime))
}

suspend fun delayAndPrint3() {
    delay(1000L)
    println("[${Thread.currentThread().name}] Hello world!")
}

fun getElapsedTime2(startTime: Long): String {
    return "지난 시간: ${System.currentTimeMillis() - startTime}ms"
}