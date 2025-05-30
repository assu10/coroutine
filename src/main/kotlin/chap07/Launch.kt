package chap07

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

@OptIn(ExperimentalStdlibApi::class)
fun main() {
    val newScope: CoroutineScope = CoroutineScope(CoroutineName("MyCoroutine") + Dispatchers.IO)
    newScope.launch(context = CoroutineName("LaunchCoroutine")) {
        println(this.coroutineContext[CoroutineName])
        println(this.coroutineContext[CoroutineDispatcher])

        val launchJob: Job? = this.coroutineContext[Job]
        val newScopeJob: Job? = newScope.coroutineContext[Job]
        println("launchJob?.parent === newScopeJob >> ${launchJob?.parent === newScopeJob}")
    }
    Thread.sleep(1000L)
}
