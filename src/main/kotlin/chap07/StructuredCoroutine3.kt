package chap07

import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> { // 부모 코루틴 생성
    // 부모 코루틴의 CoroutineContext 로부터 부모 코루틴의 Job 추출
    val myRunBlockingJob: Job? = coroutineContext[Job]
    launch { // 자식 코루틴 생성
        // 자식 코루틴의 CoroutineContext 로부터 자식 코루틴의 Job 추출
        val myLaunchJob: Job? = coroutineContext[Job]
        if (myRunBlockingJob === myLaunchJob) {
            println("runBlocking 으로 생성된 Job 과 launch 로 생성된 Job 은 동일함")
        } else {
            println("runBlocking 으로 생성된 Job 과 launch 로 생성된 Job 은 동일하지 않음")
        }
    }
}
