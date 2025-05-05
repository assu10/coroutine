package chap06

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext

fun main() = runBlocking<Unit> {
    val dispatcherKey1: CoroutineContext.Key<*> = Dispatchers.IO.key
    val dispatcherKey2: CoroutineContext.Key<*> = Dispatchers.Default.key

    println("${dispatcherKey1 === dispatcherKey2}")
}
