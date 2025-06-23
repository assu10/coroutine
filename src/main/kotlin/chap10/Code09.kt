package chap10

import kotlinx.coroutines.ExecutorCoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit>{
    val dispatcher: ExecutorCoroutineDispatcher = newFixedThreadPoolContext(2, "MyThread")
    launch(dispatcher) {
        repeat(5) {
            // launch 코루틴의 실행 중인 스레드 출력
            println("[${Thread.currentThread().name}] 스레드를 점유한 채로 대기")
            Thread.sleep(100L) // 스레드를 점유한 채로 100ms 대기
            // launch 코루틴이 재개되면 코루틴을 실행 중인 스레드 출력
            println("[${Thread.currentThread().name}] 점유한 스레드에서 마저 실행")
        }
    }
}
