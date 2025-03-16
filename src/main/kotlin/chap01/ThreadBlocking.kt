package chap01

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future

fun main() {
    val executorService: ExecutorService = Executors.newFixedThreadPool(2)
    val future: Future<String> = executorService.submit<String> {
        Thread.sleep(1000L)
        return@submit "작업1 완료"
    }
    val result = future.get() // 메인 스레드가 블로킹됨
    println(result)
    executorService.shutdown()
}
