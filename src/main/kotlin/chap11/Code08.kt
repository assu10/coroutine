package chap11

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.util.concurrent.atomic.AtomicReference

data class Counter(val name: String, val count: Int)

// 원자성 있는 Counter
val atomicCounter: AtomicReference<Counter> =
    AtomicReference(Counter(name = "MyCounter", count = 0))

fun main() = runBlocking{
    withContext(Dispatchers.Default) {
        repeat(10_000) {
            launch {
                atomicCounter.getAndUpdate { // it: Counter!
                    // MyCounter 의 count 값 1 더하기
                    it.copy(count = it.count + 1)
                }
            }
        }
    }
    println(atomicCounter.get())
}
