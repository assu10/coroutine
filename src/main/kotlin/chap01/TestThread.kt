package chap01

class TestThread : Thread() {
    override fun run() {
        println("[${currentThread().name}] 새로운 스레드 start")
        sleep(3000) // 3초 동안 대기
        println("[${currentThread().name}] 새로운 스레드 end")
    }
}

fun main() {
    println("[${Thread.currentThread().name}] 메인 스레드 start")
    //TestThread().start()
    TestThread().apply {
        isDaemon = true
    }.start()
    Thread.sleep(1000) // 1초 동안 대기
    println("[${Thread.currentThread().name}] 메인 스레드 end")
}