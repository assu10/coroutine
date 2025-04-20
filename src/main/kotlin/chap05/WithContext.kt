package chap05

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main() = runBlocking<Unit> {
    val result: String = withContext(context = Dispatchers.IO) {
        delay(1000L)
        return@withContext "test"
    }
    println(result)
}
