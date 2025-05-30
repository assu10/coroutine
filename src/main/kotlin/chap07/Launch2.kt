package chap07

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

fun main() {
    val newScope: CoroutineScope = CoroutineScope(CoroutineName("MyCoroutine"))
    newScope.launch(context = CoroutineName("LaunchCoroutine")) { // this: CoroutineScope
        this.coroutineContext[CoroutineName] // LaunchCoroutine 의 실행 환경을 CoroutineScope 를 통해 접근
        this.launch {  // CoroutineScope 로부터 LaunchCoroutine 의 실행 환경을 제공받아 코루틴 제공
            // ..
        }
    }
}
