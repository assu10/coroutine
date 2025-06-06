package chap08

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

fun main() = runBlocking<Unit>(CoroutineName("Parent")) {
    launch(context = CoroutineName("Child")) {
        withTimeout(1000L) { // 실행 시간을 1초로 제한
            delay(2000L) // 2초 걸리는 작업
            println("[${Thread.currentThread().name}] 코루틴 실행11")
        }
    }
    delay(2000L)
    println("[${Thread.currentThread().name}] 코루틴 실행22")
}
