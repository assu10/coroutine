package chap07

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val newRootJob = Job() // 루트 Job 생성
    launch(context = CoroutineName("Coroutine1") + newRootJob) {
        launch(context = CoroutineName("Coroutine3")) {
            delay(100L)
            println("[${Thread.currentThread().name}] 코루틴 실행")
        }
        launch(context = CoroutineName("Coroutine4")) {
            delay(100L)
            println("[${Thread.currentThread().name}] 코루틴 실행")
        }
    }
    launch(context = CoroutineName("Coroutine2") + newRootJob) {
        launch(context = CoroutineName("Coroutine5") + Job()) {
            delay(100L)
            println("[${Thread.currentThread().name}] 코루틴 실행")
        }
    }
    delay(50L)
    newRootJob.cancel()
    delay(1000L)
}
