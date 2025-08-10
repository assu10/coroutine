package chap11

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.util.concurrent.atomic.AtomicInteger

var count = AtomicInteger(0)

fun main() = runBlocking{
    withContext(Dispatchers.Default) {
        repeat(10_000) {
            launch {
                val currentCount = count.get()
                // 위 코드와 아래 코드의 실행 사이에 다른 스레드가 count 의 값을 읽거나 변경할 수 있음
                count.set(currentCount + 1)
//                count.getAndUpdate {
//                    it + 1
//                }
            }
        }
    }
    println("count: $count")
}
