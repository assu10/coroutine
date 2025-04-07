package chap04

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    val lazyJob: Job = launch(start = CoroutineStart.LAZY) {
        println("[${getElapsedTime(startTime)}] 지연 실행")
    }
    delay(1000L) // 1초간 대기
    lazyJob.start() // 코루틴 실행
}

fun getElapsedTime(startTime: Long): String {
    return "지난 시간: ${System.currentTimeMillis() - startTime}ms"
}