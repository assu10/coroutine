package chap02

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit>(context = CoroutineName("Main")) {
    println("[${Thread.currentThread().name}] Start")
    launch { // this: CoroutineScope
        println("[${Thread.currentThread().name}] Start")
    }
    launch(context = CoroutineName("Coroutine1")) {
        println("[${Thread.currentThread().name}] Start")
    }
    launch(context = CoroutineName("Coroutine2")) {
        println("[${Thread.currentThread().name}] Start")
    }
}
