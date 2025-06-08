package chap09

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    delayAndPrint4(keyword = "Parent Coroutine")
    launch {
        delayAndPrint4(keyword = "Child Coroutine")
    }
}

suspend fun delayAndPrint4(keyword: String) {
    delay(1000L)
    println("[${Thread.currentThread().name}] $keyword")
}
