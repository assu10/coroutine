package chap10

import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

fun main() = runBlocking<Unit> {
    val job = launch {
        while (this.isActive) {
            println("작업 중")
            yield() // 스레드 양보
        }
    }
    delay(100) // 100ms 대기(스레드 양보)
    job.cancel() // 코루틴 취소
}
