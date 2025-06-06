package chap08

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

fun main() = runBlocking<Unit>(context = CoroutineName("Parent")) {
    launch(context = CoroutineName("Coroutine")) {
        val result: String? = withTimeoutOrNull(1000L) { // 실행 시간을 1초로 제한
            delay(2000L) // 2초의 시간이 걸리는 작업
            return@withTimeoutOrNull "결과"
        }
        println("result: $result")
    }
}
