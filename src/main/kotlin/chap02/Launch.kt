package chap02

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> { // this: CoroutineScope
    println("[${Thread.currentThread().name}] Start")
    launch { // this: CoroutineScope
        println("[${Thread.currentThread().name}] Start")
    }
    launch { // this: CoroutineScope
        println("[${Thread.currentThread().name}] Start")
    }
}
