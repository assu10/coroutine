package chap10

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val startTime: Long = System.currentTimeMillis()
    repeat(10) {
        launch {
            delay(1000L) // 1초 동안 코루틴 일시 중단
            //Thread.sleep(1000L) // 1초 동안 스레드 블로킹 (코루틴의 스레드 점유 유지)
            println("[${Thread.currentThread().name}] [${getElapsedTime(startTime)}] 코루틴 $it 실행 완료")
        }
    }
}

fun getElapsedTime(startTime: Long): String = "지난 시간: ${System.currentTimeMillis() - startTime} ms"