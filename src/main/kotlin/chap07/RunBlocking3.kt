package chap07

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis() // 시작 시간
    launch {
        delay(1000L)
        println("[${Thread.currentThread().name}] launch 코루틴 종료")
    }
    delay(2000L)
    println("[${Thread.currentThread().name}] runBlocking 코루틴 종료")
    println("${chap05.getElapsedTime(startTime)}")
}

fun getElapsedTime2(startTime: Long): String {
    return "지난 시간: ${System.currentTimeMillis() - startTime}ms"
}