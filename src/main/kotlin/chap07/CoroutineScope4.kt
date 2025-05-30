package chap07

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    launch(context = CoroutineName("Coroutine1")) {
        launch(context = CoroutineName("Coroutine3")) {
            println("[${Thread.currentThread().name}] Coroutine3 코루틴 실행")
        }
        CoroutineScope(Dispatchers.IO).launch(context = CoroutineName("Coroutine4")) { // this: Coroutine
            println("[${Thread.currentThread().name}] Coroutine4 코루틴 실행")
        }
    }
    launch(context = CoroutineName("Coroutine2")) {
        println("[${Thread.currentThread().name}] Coroutine2 코루틴 실행")
    }
}
