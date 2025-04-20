package chap05

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis() // 시작 시간
    val deferred1: Deferred<Array<String>> = async(Dispatchers.IO) {
        delay(1000L)
        return@async arrayOf("111", "222")
    }
    val deferred2: Deferred<Array<String>> = async(Dispatchers.IO) {
        delay(1000L)
        return@async arrayOf("333", "444")
    }

    val result1 = deferred1.await() // deferred1 결과가 수신될 때까지 대기
    val result2 = deferred2.await() // deferred2 결과가 수신될 때까지 대기

    println("${getElapsedTime(startTime)} - 결과: ${listOf(*result1, *result2)}")
}