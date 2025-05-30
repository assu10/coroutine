package chap07

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> { // 루트 Job 생성
    val newScope: CoroutineScope = CoroutineScope(Dispatchers.IO) // 새로운 루트 Job 생성
    newScope.launch(context = CoroutineName("Coroutine1")) { // Coroutine1 실행
        launch(CoroutineName("Coroutine3")) { // Coroutine3 실행
            delay(100L)
            println("[${Thread.currentThread().name}] 코루틴 실행")
        }
        launch(CoroutineName("Coroutine4")) { // Coroutine4 실행
            delay(100L)
            println("[${Thread.currentThread().name}] 코루틴 실행")
        }
    }
    newScope.launch(context = CoroutineName("Coroutine2")) { // Coroutine2 실행
        launch(CoroutineName("Coroutine5")) { // Coroutine5 실행
            delay(100L)
            println("[${Thread.currentThread().name}] 코루틴 실행")
        }
    }
    newScope.cancel()
    delay(1000L)
}
