package chap06

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext

fun main() = runBlocking<Unit> {
    val myCoroutineName: CoroutineName = CoroutineName("MyCoroutine")
    val myDispatcher: CoroutineDispatcher = Dispatchers.IO
    val myCoroutineContext: CoroutineContext = myCoroutineName + myDispatcher

    println(myCoroutineContext[myCoroutineName.key])
    println(myCoroutineContext[myDispatcher.key])
}
