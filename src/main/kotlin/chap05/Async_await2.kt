package chap05

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()

    val hello: Deferred<String> = async(context = Dispatchers.IO) {
        delay(1000L)
        return@async "hello"
    }

    val world: Deferred<String> = async(context = Dispatchers.IO) {
        delay(1000L)
        return@async "world"
    }

    val result = awaitAll(hello, world
    )
    println("[${getElapsedTime(startTime)}] ${result[0]} ${result[1]}")
}