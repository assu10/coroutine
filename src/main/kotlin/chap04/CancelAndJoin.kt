package chap04

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    val longJob: Job = launch(context = Dispatchers.Default) {
        repeat(10) { repeatTime ->
            delay(1000) // 1초간 대기
            println("[${getElapsedTime(startTime)}] 반복횟수 ${repeatTime}")
        }
    }
    delay(5500) // 5.5초간 대기
    longJob.cancelAndJoin() // 코루틴 취소
    afterJobCancelled()
}

fun afterJobCancelled() {
    println("다른 작업")
}