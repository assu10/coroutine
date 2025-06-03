package chap08

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    // CoroutineContext  에 SupervisorJob() 객체 설정
    val coroutineScope = CoroutineScope(context = SupervisorJob())

    coroutineScope.apply {
        launch(context = CoroutineName("Coroutine1")) {
            launch(context = CoroutineName("Coroutine3")) {
                throw Error("예외 발생")
            }
            delay(100L)
            println("[${Thread.currentThread().name}] 코루틴 실행")
        }
        launch(context = CoroutineName("Coroutine2")) {
            delay(100L)
            println("[${Thread.currentThread().name}] 코루틴 실행")
        }
    }
    delay(1000L)
}
