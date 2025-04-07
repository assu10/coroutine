package chap04

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> { // 실행 중 상태의 Job 생성
    val job: Job = launch {
        delay(1000) // 1초간 대기
    }
    delay(2000) // 2초간 대기
    printJobState(job)
}