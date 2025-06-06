package chap08

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val job: Job = launch {
        delay(1000L)
    }
    job.invokeOnCompletion { e ->
        println("------------ ${e}") // 발생한 예외 출력
    }
    job.cancel() // job 취소
}
