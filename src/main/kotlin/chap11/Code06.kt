package chap11

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

var count5 = 0
val countChangeDispatcher = newSingleThreadContext("countChangeThread")

fun main() = runBlocking<Unit> {
    withContext(Dispatchers.Default) {
        repeat(10_000) {
            launch { // count 값을 변경시킬대만 사용
                increaseCount()
            }
        }
    }
    println("[${Thread.currentThread().name}] $count5")
}

suspend fun increaseCount() {
    coroutineScope {
        withContext(countChangeDispatcher) {
            count5++
        }
    }
}
