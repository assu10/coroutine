package chap12

import kotlinx.coroutines.delay

class RepeatAddWithDelayUseCase {
    suspend fun add(repeatTime: Int): Int {
        var result = 0
        repeat(times = repeatTime) {
            delay(100L)
            result++
        }
        return result
    }
}