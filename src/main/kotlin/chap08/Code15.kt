package chap08

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    try {
        launch(context = CoroutineName("Coroutine1")) {
            throw Exception("코루틴 1 에서 예외 발생")
        }
    } catch (e: Exception) {
        println(e.message)
    }

    launch(context = CoroutineName("Coroutine2")) {
        delay(100L)
        println("코루틴2 실행")
    }
}
