package chap04

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val updatedTokenJob: Job = launch(context = Dispatchers.IO) {
        println("[${Thread.currentThread().name}] 토큰 업데이트 시작")
        delay(100L)
        println("[${Thread.currentThread().name}] 토큰 업데이트 완료")
    }
    val networkCallJob: Job = launch(context = Dispatchers.IO) {
        println("[${Thread.currentThread().name}] 네트워크 요청")
    }
}
