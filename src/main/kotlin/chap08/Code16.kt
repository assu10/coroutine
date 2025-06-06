package chap08

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope

fun main() = runBlocking<Unit> {
    supervisorScope {
        val deferred: Deferred<String> = async(context = CoroutineName("Coroutine1")) {
            throw Exception("코루틴1 예외 발생")
        }
        try {
            deferred.await()
        } catch (e: Exception) {
            println("예외 잡음~ ${e.message}")
        }
    }
}
