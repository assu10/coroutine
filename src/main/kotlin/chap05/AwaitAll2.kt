package chap05

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis() // 시작 시간
    val deferred1: Deferred<Array<String>> = async(Dispatchers.IO) {
        delay(1000L)
        arrayOf("111", "222")
    }

    val deferred2: Deferred<Array<String>> = async(Dispatchers.IO) {
        delay(1000L)
        arrayOf("333", "444")
    }

    listOf(deferred1, deferred2).awaitAll()

    val result: List<Array<String>> = listOf(deferred1, deferred2).awaitAll()

    println("${getElapsedTime(startTime)} - 결과: ${listOf(*result[0], *result[1])}")
}