package chap06

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext

fun main() = runBlocking<Unit> {
    val myCoroutineContext: CoroutineContext = newSingleThreadContext("myThread") + CoroutineName("myCoroutine")
    val newMyCoroutineContext: CoroutineContext = myCoroutineContext + CoroutineName("newMyCoroutine")

    launch(context = newMyCoroutineContext) {
        println("[${Thread.currentThread().name}] 실행")
    }
}