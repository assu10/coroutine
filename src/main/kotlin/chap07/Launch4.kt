package chap07

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    // 하위 launch 코루틴
    // 호출부의 스레드를 차단하고 실행되는 것이 아니기 때문에 즉시 실행되지 않고,
    // runBlocking 코루틴이 메인 스레드를 양보하고 나서야 메인 스레드로 보내져서 실행됨
    launch {
        delay(1000L)
        println("[${Thread.currentThread().name}] 하위 코루틴 종료")
    }
    println(getElapsedTime(startTime)) // 지난 시간 출력
}

fun getElapsedTime4(startTime: Long): String {
    return "지난 시간: ${System.currentTimeMillis() - startTime}ms"
}