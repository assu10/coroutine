package chap05

import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

private val dispatcher1 = newSingleThreadContext("myThread1")
private val dispatcher2 = newSingleThreadContext("myThread2")

fun main() = runBlocking<Unit> {
    println("[${Thread.currentThread().name}] 코루틴 실행~")

    withContext(context = dispatcher1) {
        println("[${Thread.currentThread().name}] dispatcher1 코루틴 실행~")
        withContext(context = dispatcher2) {
            println("[${Thread.currentThread().name}] dispatcher2 코루틴 실행~")
        }
        println("[${Thread.currentThread().name}] dispatcher1 코루틴 실행~")
    }
    println("[${Thread.currentThread().name}] 코루틴 실행~")
}