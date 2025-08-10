package chap11

import kotlinx.coroutines.CancellableContinuation
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.concurrent.thread
import kotlin.coroutines.resume

fun main() = runBlocking<Unit> {
    // 코루틴을 중단시키고 String 타입의 결과를 기다림
    val result = suspendCancellableCoroutine<String> { continuation: CancellableContinuation<String> ->
        // 별도의 스레드에서 비동기 작업 수행
        thread { // 새로운 스레드 생성
            Thread.sleep(1000L) // 1초간 무언가 처리한다고 가정
            val workResult = "이게 작업 결과"
            // 작업 결과를 담아 코루틴 재개
            continuation.resume(workResult)
        }
    }
    println(result) // 코루틴 재개 시 반환받은 결과 출력
}
