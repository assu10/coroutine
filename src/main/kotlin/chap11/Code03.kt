package chap11

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext

var count2 = 0
val mutex: Mutex = Mutex()

fun main() = runBlocking<Unit>{
    withContext(Dispatchers.Default){
        repeat(10_000) {
            launch {
                mutex.withLock {
                    count2++
                }
            }
        }
    }
    println(count2)
}
