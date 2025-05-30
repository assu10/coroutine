package chap07

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    // Dispatchers.IO 와 새로운 Job 객체로 구성된 CoroutineContext 를 가진 CoroutineScope 객체 생성
    val coroutineScope = CoroutineScope(Dispatchers.IO)
    coroutineScope.launch {
        delay(100L) // 100ms 대기
        println("[${Thread.currentThread().name}] 코루틴 실행 완료")
    }
    Thread.sleep(1000L) // 코드 종료 방지
}
