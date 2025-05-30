package chap07

import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> { // this: CoroutineScope (runBlocking 코루틴의 실행 환경을 담은 CoroutineScope)
    this.launch { // this: CoroutineScope (launch 코루틴의 실행 환경을 담은 CoroutineScope)
        this.async { // this: CoroutineScope (async 코루틴의 실행 환경을 담은 CoroutineScope)

        }
    }
}
