package chap11

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    launch(start = CoroutineStart.UNDISPATCHED) {
        println("[${Thread.currentThread().name}] 일시 중단 전에는 CoroutineDispatcher 를 거치지 않고 실행됨")
        delay(100L)
        println("[${Thread.currentThread().name}] 일시 중단 후에는 CoroutineDispatcher 를 거쳐서 실행됨")
    }
}
