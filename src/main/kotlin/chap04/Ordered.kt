package chap04

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val updatedTokenJob: Job = launch(context = Dispatchers.IO) {
        println("[${Thread.currentThread().name}] 토큰 업데이트 시작")
        delay(100L)
        println("[${Thread.currentThread().name}] 토큰 업데이트 완료")
    }
    val independentJob: Job = launch(context = Dispatchers.IO) {
        println("[${Thread.currentThread().name}] 독립적인 작업 실행")
    }
    updatedTokenJob.join() // updatedTokenJob 이 완료될 때까지 일시 중단
    val networkCallJob: Job = launch(context = Dispatchers.IO) {
        println("[${Thread.currentThread().name}] 네트워크 요청")
    }

    joinAll()
}
