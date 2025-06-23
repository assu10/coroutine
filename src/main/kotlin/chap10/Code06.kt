package chap10

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val job = launch {
        println("[${Thread.currentThread().name}] 1. launch 코루틴 작업 시작")
        delay(1000L) // 1초간 대기
        println("[${Thread.currentThread().name}] 2. launch 코루틴 작업 완료")
    }
    println("[${Thread.currentThread().name}] 3. runBlocking 코루틴이 곧 일시 중단되고 메인 스레드가 양보됨")
    //job.join() // job 내부의 코드가 모두 실행될 때까지 메인 스레드 일시 중단
    println("[${Thread.currentThread().name}] 4. runBlocking 메인 스레드에 분배되어 작업이 다시 재개됨")
}
