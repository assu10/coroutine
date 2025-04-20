package chap05

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val result: String = async(context = Dispatchers.IO) {
        delay(1000L)
        return@async "test"
    }.await()

    println(result)
}
