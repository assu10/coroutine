package chap04

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit>{
    val whileJob: Job = launch(context = Dispatchers.Default) {
        while(this.isActive) {
            println("작업 중...")
        }
    }
    delay(100L) // 100ms 대기
    whileJob.cancel() // 코루틴 취소
}