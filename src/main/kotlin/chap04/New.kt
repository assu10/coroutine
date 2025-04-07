package chap04

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val job: Job = launch(start = CoroutineStart.LAZY) {
        delay(1000)
    }
    printJobState(job)
}

fun printJobState(job: Job) {
    println("🔍 Job 상태 확인:")
    println("- isActive: ${job.isActive}     // 실행 중이며, 완료되지 않았고, 취소되지 않은 상태")
    println("- isCancelled: ${job.isCancelled} // 취소가 요청된 상태")
    println("- isCompleted: ${job.isCompleted} // 정상 완료되었거나 예외 또는 취소로 종료된 상태")
}
