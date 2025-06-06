package chap08

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("Caught~~ [[$throwable]]")
    }
    CoroutineScope(context = exceptionHandler).launch(context = CoroutineName("Coroutine1")) {
        launch(context = CoroutineName("Coroutine2")) {
            throw Exception("코루틴 2에 예외 발생")
        }
    }
    delay(1000L)
}
