package chap08

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val parentJob = launch(context = CoroutineName("parentCoroutine")) {
        launch(context = CoroutineName("Coroutine1") + Job()) {
            launch(context = CoroutineName("Coroutine3")) {
                delay(100L)
                println("[${Thread.currentThread().name}] 코루틴 실행")
            }
            delay(100L)
            println("[${Thread.currentThread().name}] 코루틴 실행")
        }

        launch(context = CoroutineName("Coroutine2")) {
            delay(100L)
            println("[${Thread.currentThread().name}] 코루틴 실행")
        }
    }

    delay(20L) // 코틀린들이 모두 생성될 때까지 대기
    parentJob.cancel() // ParentCoroutine 에 취소 요청
    delay(1000L)
}
