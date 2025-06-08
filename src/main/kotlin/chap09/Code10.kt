package chap09

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope

//suspend fun searchByKeyword3(keyword: String): Array<String> {
//    val dbResults = searchFromDB(keyword)
//    val serverResults = searchFromServer(keyword)
//    return arrayOf(*dbResults, *serverResults)
//}

// 주석 해제하여 오류 확인
//suspend fun searchByKeyword2(keyword: String): Array<String> {
//    val dbResults = async {
//        searchFromDB(keyword)
//    }
//    val serverResults = async {
//        searchFromServer(keyword)
//    }
//    return arrayOf(*dbResults.await(), *serverResults.await())
//}

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    val results = searchByKeyword("하하하")
    println("[${Thread.currentThread().name}] 결과: ${results.toList()}")
    println(getElapsedTime3(startTime))
}

//suspend fun searchByKeyword(keyword: String): Array<String> = coroutineScope { // this: CoroutineScope
//    val dbResultsDeferred: Deferred<Array<String>> = async {
//        searchFromDB(keyword)
//    }
//    val serverResultsDeferred: Deferred<Array<String>> = async {
//        searchFromServer(keyword)
//    }
//    return@coroutineScope arrayOf(*dbResultsDeferred.await(), *serverResultsDeferred.await())
//}

suspend fun searchByKeyword(keyword: String): Array<String> = supervisorScope { // this: CoroutineScope
    val dbResultsDeferred: Deferred<Array<String>> = async {
        throw Exception("dbResultsDeferred 에서 예외 발생")
        searchFromDB(keyword)
    }
    val serverResultsDeferred: Deferred<Array<String>> = async {
        searchFromServer(keyword)
    }

    val dbResults = try {
        dbResultsDeferred.await()
    } catch (e: Exception) {
        arrayOf() // 예외 발생 시 빈 결과 반환
    }

    val serverResults = try {
        serverResultsDeferred.await()
    } catch (e: Exception) {
        arrayOf() // 예외 발생 시 빈 결과 반환
    }

    return@supervisorScope arrayOf(*dbResults, *serverResults)
}

suspend fun searchFromDB(keyword: String): Array<String> {
    delay(1000L)
    return arrayOf("[DB] ${keyword} 1", "[DB] ${keyword} 2")
}

suspend fun searchFromServer(keyword: String): Array<String> {
    delay(1000L)
    return arrayOf("[Server] ${keyword} 1", "[Server] ${keyword} 2")
}

fun getElapsedTime3(startTime: Long): String {
    return "지난 시간: ${System.currentTimeMillis() - startTime}ms"
}