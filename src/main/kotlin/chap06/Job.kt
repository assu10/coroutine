package chap06

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext

fun main() = runBlocking<Unit> {
    val myJob = Job()
    val coroutineContext: CoroutineContext = Dispatchers.IO + myJob

    launch(context = coroutineContext) {
        println("[${Thread.currentThread().name}] 실행")
    }
}
