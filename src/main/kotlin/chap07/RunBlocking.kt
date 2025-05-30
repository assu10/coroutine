package chap07

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    delay(1000L)
    println("[${Thread.currentThread().name}] 코루틴 종료")
}
