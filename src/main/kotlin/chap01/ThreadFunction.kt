package chap01

import java.lang.Thread.currentThread
import java.lang.Thread.sleep
import kotlin.concurrent.thread

fun main() {
    println("[${currentThread().name}] 메인 스레드 start")
    thread(isDaemon = false) {
        println("[${currentThread().name}] 새로운 스레드 start")
        sleep(3000) // 3초 동안 대기
        println("[${currentThread().name}] 새로운 스레드 end")
    }
    println("[${currentThread().name}] 메인 스레드 end")
}