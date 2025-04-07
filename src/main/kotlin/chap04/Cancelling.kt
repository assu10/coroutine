package chap04

import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> { // 실행 중 상태의 Job 생성
    val job: Job = launch {
        while(true) {
            // to do..
        }
    }
    job.cancel() // 코루틴 취소 요청
    printJobState(job)
}