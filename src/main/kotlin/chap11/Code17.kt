package chap11

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit>{
    // Dispatchers.Unconfined 를 사용해 실행되는 코루틴
    launch(Dispatchers.Unconfined) {
        println("launch 코루틴 실행 스레드: ${Thread.currentThread().name}") // launch 코루틴이 실행되는 스레드 출력
    }

    launch(Dispatchers.Default) {
        println("launch 코루틴 실행 스레드: ${Thread.currentThread().name}") // launch 코루틴이 실행되는 스레드 출력
    }
}
