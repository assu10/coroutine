package chap01

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

fun main() {
    val startTime = System.currentTimeMillis()
    // ExecutorService 생성(스레드 개수는 2로 설정)
    val executorService: ExecutorService = Executors.newFixedThreadPool(2)

    // 작업 1 제출
    executorService.submit {
        println("[${Thread.currentThread().name}][${getElapsedTime(startTime)}] 작업 1 시작~")
        Thread.sleep(1000L) // 1초간 대기
        println("[${Thread.currentThread().name}][${getElapsedTime(startTime)}] 작업 1 완료~")
    }

    // 작업 2 제출
    executorService.submit {
        println("[${Thread.currentThread().name}][${getElapsedTime(startTime)}] 작업 2 시작~")
        Thread.sleep(1000L) // 1초간 대기
        println("[${Thread.currentThread().name}][${getElapsedTime(startTime)}] 작업 2 완료~")
    }

    // 작업 3 제출
    executorService.submit {
        println("[${Thread.currentThread().name}][${getElapsedTime(startTime)}] 작업 3 시작~")
        Thread.sleep(1000L) // 1초간 대기
        println("[${Thread.currentThread().name}][${getElapsedTime(startTime)}] 작업 3 완료~")
    }

    // ExecutorService 종료
    executorService.shutdown()
}

fun getElapsedTime(startTime: Long): String = "지난 시간: ${System.currentTimeMillis() - startTime} ms"