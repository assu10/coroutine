package chap06

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext

fun main() = runBlocking{
    val myCoroutineName = CoroutineName("myCoroutineName")
    val myDispatcher = Dispatchers.IO
    val myJob = Job()
    val myCoroutineContext: CoroutineContext = myCoroutineName + myDispatcher + myJob

    val deletedCoroutineContext = myCoroutineContext.minusKey(CoroutineName)

    println("===== deletedCoroutineContext =====")
    println(deletedCoroutineContext[CoroutineName]) // or CoroutineName.Key
    println(deletedCoroutineContext.get(Dispatchers.IO.key))
    println(deletedCoroutineContext[Job]) // or Job.Key

    println("===== myCoroutineContext =====")
    println(myCoroutineContext[CoroutineName]) // or CoroutineName.Key
    println(myCoroutineContext.get(Dispatchers.IO.key))
    println(myCoroutineContext[Job]) // or Job.Key
}
