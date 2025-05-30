package chap07

import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> { // 부모 코루틴
    // 부모 코루틴의 CoroutineContext 로부터 부모 코루틴의 Job 추출
    val parentJob: Job? = coroutineContext[Job]
    launch { // 자식 코루틴
        // 자식 코루틴의 CoroutineContext 로부터 자식 코루틴의 Job 추출
        val childJob: Job? = coroutineContext[Job]
        println("부모 코루틴과 자식 코루틴의 Job 이 같은가? ${parentJob === childJob}")
        println("자식 코루틴의 Job 이 가지고 있는 parent 는 부모 코루틴의 Job 인가? ${childJob?.parent === parentJob}")
        println("부모 코루틴의 Job 은 자식 코루틴의 Job 을 참조를 가지는가? ${parentJob?.children?.contains(childJob)}")
    }
}
