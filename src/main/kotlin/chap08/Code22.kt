package chap08

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

fun main() = runBlocking<Unit>(context = CoroutineName("Parent")) {
    try {
        withTimeout(2000L) {
            delay(2000L) // 2초의 작업이 걸리는 작업
            println("[${Thread.currentThread().name}] 코루틴 실행")
        }
    } catch (e: Exception) {
        println("e: ${e}")
    }
}
