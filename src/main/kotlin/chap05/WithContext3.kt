package chap05

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()

    val hello:String = withContext(context = Dispatchers.IO) {
        delay(1000L)
        return@withContext "hello"
    }

    val world: String = withContext(context = Dispatchers.IO) {
        delay(1000L)
        return@withContext "world"
    }

    println("[${getElapsedTime(startTime)}] ${hello} ${world}")
}