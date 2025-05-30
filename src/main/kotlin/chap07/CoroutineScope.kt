package chap07

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlin.coroutines.CoroutineContext

class CustomCoroutineScope: CoroutineScope {
    // Job 객체와 CoroutineDispatcher 객체를 CoroutineContext 로 가짐
    override val coroutineContext: CoroutineContext = Job() + newSingleThreadContext("CustomScopeThread")
}

fun main() {
    val coroutineScope: CoroutineScope = CustomCoroutineScope()
    // CustomCoroutineScope 객체로부터 실행 환경을 제공받는 코루틴 실행
    coroutineScope.launch {
        delay(100L) // 100ms 대기
        println("[${Thread.currentThread().name}] 코루틴 실행 완료")
    }
    Thread.sleep(1000L) // 코드 종료 방지
}
