package chap04

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val convertImageJob1: Job = launch(context = Dispatchers.Default) {
        Thread.sleep(1000L) // 이미지 변환 작업 실행 시간
        println("[${Thread.currentThread().name}] 이미지1 변환 완료")
    }

    val convertImageJob2: Job = launch(context = Dispatchers.Default) {
        Thread.sleep(1000L) // 이미지 변환 작업 실행 시간
        println("[${Thread.currentThread().name}] 이미지2 변환 완료")
    }

    // 둘 다 변환될 때까지 대기
    joinAll(convertImageJob1, convertImageJob2)

    val uploadImageJob: Job = launch(context = Dispatchers.IO) {
        println("[${Thread.currentThread().name}] 이미지 업로드")
    }
}
