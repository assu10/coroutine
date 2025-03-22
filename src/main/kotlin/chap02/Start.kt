package chap02

import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    // 현재 실행 중인 스레드 출력
    println("[${Thread.currentThread().name}] Start")
}
