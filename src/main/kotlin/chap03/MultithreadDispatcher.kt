package chap03

import kotlinx.coroutines.launch
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val testMultiThreadDispatcher = newFixedThreadPoolContext(
        nThreads = 2,
        name = "TestMultiThreadDispatcher",
    )
    launch(context = testMultiThreadDispatcher) {
        println("[${Thread.currentThread().name}] 실행")
    }
    launch(context = testMultiThreadDispatcher) {
        println("[${Thread.currentThread().name}] 실행")
    }
    launch(context = testMultiThreadDispatcher) {
        println("[${Thread.currentThread().name}] 실행")
    }
}
