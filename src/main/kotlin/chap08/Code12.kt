package chap08

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val exceptionHandler: CoroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("예외 로깅~~ $throwable")
    }
    CoroutineScope(Dispatchers.IO)
        .launch(context = CoroutineName("Coroutine1") + exceptionHandler) {
            launch(context = CoroutineName("Coroutine2")) {
                throw Exception("코루틴2에 예외 발생함")
            }
            launch(context = CoroutineName("Coroutine3")) {
                delay(200L)
                println("코루틴 3 실행")
            }
        }
    delay(1000L)
}
