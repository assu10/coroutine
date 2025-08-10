package chap11

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

@Volatile
var count1 = 0

fun main() = runBlocking<Unit> {
    withContext(Dispatchers.Default) {
        repeat(10000) {
            launch {
                count1++
            }
        }
    }
    println(count1)
}
