package chap11

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit>{
    launch {
        println("[${Thread.currentThread().name}] 작업 1")
    }
    println("[${Thread.currentThread().name}] 작업 2")
}
