package chap07

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit>(Dispatchers.IO) {
    delay(1000L)
    println("[${Thread.currentThread().name}] 코루틴 종료")
}
