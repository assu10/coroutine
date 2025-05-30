package chap07

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val parentJob = launch(context = Dispatchers.IO) { // 부모 코루틴
        val dbResultsDeferred: List<Deferred<String>> = listOf("db1", "db2", "db3").map {
            async { // 자식 코루틴 생성
                delay(1000L) // DB 로부터 데이터를 가져오는데 걸리는 시간
                println("${it} 으로부터 데이터 가져옴")
                return@async "(${it}) Data~"
            }
        }
        // 모든 코루틴이 완료될 때까지 대기
        val dbResults: List<String> = dbResultsDeferred.awaitAll()
        println(dbResults)
    }

    // 부모 코루틴에 취소 요청
    parentJob.cancel()
}
