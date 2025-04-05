package chap03

import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val singleDispatcher = newSingleThreadContext(name = "Single~")
    launch(context = singleDispatcher) {
        println("[${Thread.currentThread().name}] 실행")
    }
}
