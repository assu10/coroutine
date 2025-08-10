package chap11

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit>(Dispatchers.IO) {
    println("runBlocking 코루틴 실행 스레드: ${Thread.currentThread().name}") // runBlocking 코루틴이 실행되는 스레드 출력
    launch {
        println("launch 코루틴 실행 스레드: ${Thread.currentThread().name}") // launch 코루틴이 실행되는 스레드 출력
    }
}
