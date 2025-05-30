package chap07

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit>{
    launch(context = CoroutineName("Coroutine1")) {
        val coroutine1Job = this.coroutineContext[Job] // Coroutine1 의 Jo
        val newJob = Job(parent = coroutine1Job)
        launch(context = CoroutineName("Coroutine2") + newJob) {
            delay(100L)
            println("[${Thread.currentThread().name}] 코루틴 실행")
        }
        newJob.complete() // 명시적으로 완료 호출
    }
    delay(1000L)
}
