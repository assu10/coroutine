package chap07

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    // 하위 runBlocking 코루틴
    // 바깥쪽 runBlocking 코루틴이 차단한 스레드를 사용할 수 있기 때문에 메인 스레드 상에서 실행되며,
    // 실행되는 동안 메인 스레드를 차단함
    runBlocking {
        delay(1000L)
        println("[${Thread.currentThread().name}] 하위 코루틴 종료")
    }
    println(getElapsedTime(startTime)) // 지난 시간 출력
}

fun getElapsedTime3(startTime: Long): String {
    return "지난 시간: ${System.currentTimeMillis() - startTime}ms"
}