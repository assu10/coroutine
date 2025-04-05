package chap03

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit>   {
    launch(context = Dispatchers.Default) {
        println("[${Thread.currentThread().name}] 코루틴 실행")
    }
}
