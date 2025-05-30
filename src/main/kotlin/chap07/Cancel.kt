package chap07

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    launch(context = CoroutineName("Coroutine1")) {
        launch(context = CoroutineName("Coroutine3")) {
            delay(100L)
            println("[${Thread.currentThread().name}] 코루틴 실행 완료")
        }
        launch(context = CoroutineName("Coroutine4")) {
            delay(100L)
            println("[${Thread.currentThread().name}] 코루틴 실행 완료")
        }

        // Coroutine1 의 CoroutineScope 에 취소 요청
        this.cancel()
    }
    launch(context = CoroutineName("Coroutine2")) {
        delay(100L)
        println("[${Thread.currentThread().name}] 코루틴 실행 완료")
    }
}
