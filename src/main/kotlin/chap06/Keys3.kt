package chap06

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.runBlocking

fun main() = runBlocking{
    val myCoroutineName: CoroutineName = CoroutineName("MyCoroutine")

    if (myCoroutineName.key === CoroutineName.Key) {
        println("myCoroutineName.key와 CoroutineName.Key 는 동일함")
    }
}
