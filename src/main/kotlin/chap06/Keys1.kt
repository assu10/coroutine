package chap06

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val myCoroutineContext = CoroutineName("MyCoroutine") + Dispatchers.IO

    // myCoroutineContext 에 대해 get() 의 인자로 CoroutineName.Key 를 넘김으로써
    // myCoroutineContext 를 구성하는 CoroutineName 객체만 가져옴
    val nameFromContext1 = myCoroutineContext.get(CoroutineName)

    // get() 은 연산자 함수(operator fun) 이므로 대괄호로 대체 가능
    val nameFromContext2 = myCoroutineContext[CoroutineName]

    println(nameFromContext1)
    println(nameFromContext2)
}
