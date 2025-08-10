package chap11

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    launch(context = Dispatchers.Unconfined) {
        println("일시 중단 전 실행 스레드: ${Thread.currentThread().name}")
        delay(1000)
        println("일시 중단 후 실행 스레드: ${Thread.currentThread().name}")
    }
}
