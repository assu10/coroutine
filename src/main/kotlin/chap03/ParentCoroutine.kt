package chap03

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val testMultiThreadDispatcher =
        newFixedThreadPoolContext(
            nThreads = 2,
            name = "testMultiThread",
        )
    launch(context = testMultiThreadDispatcher) { // 부모 코루틴
        println("[${Thread.currentThread().name}] 부모 코루틴 실행-0")
        launch { // 자식 코루틴 실행
            println("[${Thread.currentThread().name}] 부모 코루틴 실행-1")
            println("[${Thread.currentThread().name}] 자식 코루틴 실행-1")
            println("[${Thread.currentThread().name}] 자식 코루틴 실행-1")
        }
        launch { // 자식 코루틴 실행
            println("[${Thread.currentThread().name}] 자식 코루틴 실행-2")
        }
    }
}
