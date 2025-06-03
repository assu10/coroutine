package chap08

import kotlinx.coroutines.CompletableJob
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    // supervisorJob 의 parent 로 runBlocking 으로 생성된 Job 객체 설정
    val supervisor: CompletableJob = SupervisorJob(parent = this.coroutineContext[Job])

    launch(context = CoroutineName("Coroutine1") + supervisor) { // supervisor 객체 사용
        launch(context = CoroutineName("Coroutine3")) {
            throw Exception("예외 발생")
        }
        delay(100L)
        println("[${Thread.currentThread().name}] 코루틴 실행")
    }
    launch(context = CoroutineName("Coroutine2") + supervisor) { // supervisor 객체 사용
        delay(100L)
        println("[${Thread.currentThread().name}] 코루틴 실행")
    }
    // supervisor 완료 처리 (이게 없으면 전체 코루틴 종료가 되지 않음)
    supervisor.complete()
}
