package chap11

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    println("runBlocking 코루틴 스레드: ${Thread.currentThread().name}")

    launch(start = CoroutineStart.UNDISPATCHED) {
        println("CoroutineStart.UNDISPATCHED 코루틴이 시작 시 사용하는 스레드: ${Thread.currentThread().name}")
        delay(100L)
        println("CoroutineStart.UNDISPATCHED 코루틴이 재개 시 사용하는 스레드: ${Thread.currentThread().name}")
    }.join()

    launch(context = Dispatchers.Unconfined) {
        println("Dispatchers.Unconfined 코루틴이 시작 시 사용하는 스레드: ${Thread.currentThread().name}")
        delay(100L)
        println("Dispatchers.Unconfined 코루틴이 재개 시 사용하는 스레드: ${Thread.currentThread().name}")
    }.join()
}
