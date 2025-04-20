package chap04

import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> { // 실행 중 상태의 Job 생성
    val job: Job = launch {
        delay(2000)
    }
    job.cancelAndJoin() // 코루틴 취소 요청 + 취소가 완료될 때까지 대기
    printJobState(job)

}