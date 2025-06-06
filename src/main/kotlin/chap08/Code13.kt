package chap08

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val exceptionHandler: CoroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("Caught~ $throwable")
        println("Caught~ $throwable")
        println("Caught~ $throwable")
    }
    launch(context = CoroutineName("Coroutine1") + exceptionHandler) {
        throw Exception("예외가 발생함")
    }
}
