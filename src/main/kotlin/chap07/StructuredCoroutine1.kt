package chap07

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val myCoroutineContext = newSingleThreadContext("MyThread") + CoroutineName("CoroutineA")
    launch(context = myCoroutineContext) { // 부모 코루틴 생성
        println("[${Thread.currentThread().name}] 부모 코루틴 실행")
        launch { // 자식 코루틴 생성
            println("[${Thread.currentThread().name}] 자식 코루틴 실행")
        }
    }
}
