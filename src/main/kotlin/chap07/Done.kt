package chap07

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking <Unit>{
    val startTime = System.currentTimeMillis()
    val parentJob = launch {// 부모 코루틴 실행
        launch { // 자식 코루틴 실행
            delay(1000L) // 1초간 대기
            println("[${getElapsedTime(startTime)}] 자식 코루틴 실행 완료")
        }
        println("[${getElapsedTime(startTime)}] 부모 코루틴이 실행하는 마지막 코드")
    }
    parentJob.invokeOnCompletion { // 부모 코루틴이 종료될 시 호출되는 콜백 등록
        println("[${getElapsedTime(startTime)}] 부모 코루틴 실행 완료")
    }
    delay(500L) // 500ms 대기

    printJobState(parentJob)
}

fun getElapsedTime(startTime: Long): String = "지난 시간: ${System.currentTimeMillis() - startTime} ms"

fun printJobState(job: Job) {
    println("🔍 Job 상태 확인:")
    println("- isActive: ${job.isActive}     // 실행 중이며, 완료되지 않았고, 취소되지 않은 상태")
    println("- isCancelled: ${job.isCancelled} // 취소가 요청된 상태")
    println("- isCompleted: ${job.isCompleted} // 정상 완료되었거나 예외 또는 취소로 종료된 상태")
}