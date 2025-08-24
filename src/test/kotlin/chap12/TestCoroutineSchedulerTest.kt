package chap12

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.currentTime
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test

class TestCoroutineSchedulerTest {
//    @Test
//    fun `가상 시간 조절 테스트`() {
//        // 테스트 환경 설정
//        val testCoroutineScheduler = TestCoroutineScheduler()
//
//        // 가상 시간에서 5초 흐르게 만듦: 현재 시간 5초
//        testCoroutineScheduler.advanceTimeBy(delayTimeMillis = 5000L)
//        assertEquals(5000L, testCoroutineScheduler.currentTime)
//
//        // 가상 시간에서 6초를 흐르게 만듦: 현재 시간 11초
//        testCoroutineScheduler.advanceTimeBy(delayTimeMillis = 6000L)
//        assertEquals(11000L, testCoroutineScheduler.currentTime)
//    }
//
//    @Test
//    fun `가상 시간 위에서 테스트 진행`() {
//        // 테스트 환경 설정
//        val testCoroutineScheduler: TestCoroutineScheduler = TestCoroutineScheduler()
//        val testDispatcher: TestDispatcher = StandardTestDispatcher(scheduler = testCoroutineScheduler)
//        val testCoroutineScope = CoroutineScope(context = testDispatcher)
//
//        // Given
//        var result = 0
//
//        // When
//        testCoroutineScope.launch {
//            delay(10000L) // 10초간 대기
//            result = 1
//            delay(10000L) // 10초간 대기
//            result = 2
//            println(Thread.currentThread().name) // Test worker @coroutine#1
//        }
//
//        // Then
//        assertEquals(0, result)
//
//        // 가상 시간에서 5초 흐르게 함: 현재 시간 5초
//        testCoroutineScheduler.advanceTimeBy(5000L)
//        assertEquals(0, result)
//
//        // 가상 시간에서 6초 흐르게 함: 현재 시간 11초
//        testCoroutineScheduler.advanceTimeBy(6000L)
//        assertEquals(1, result)
//
//        // 가상 시간에서 10초 흐르게 함: 현재 시간 21초
//        testCoroutineScheduler.advanceTimeBy(10000L)
//        assertEquals(2, result)
//    }
//
//    @Test
//    fun `advanceUntilIdle(), StandardDispatcher() 사용`() {
//        // 테스트 환경 설정
//        val testDispatcher: TestDispatcher = StandardTestDispatcher()
//        val testCoroutineScope: CoroutineScope = CoroutineScope(context = testDispatcher)
//
//        // Given
//        var result = 0
//
//        // When
//        testCoroutineScope.launch {
//            delay(10000L) // 10초간 대기
//            result = 1
//            delay(10000L) // 10초간 대기
//            result = 2
//        }
//
//        // Then
//        // testCoroutineScope 내부의 코루틴이 모두 실행되게 만듦
//        testDispatcher.scheduler.advanceUntilIdle()
//        assertEquals(2, result)
//    }
//
//    @Test
//    fun `TestScope() 사용`() {
//        val testCoroutineScope: TestScope = TestScope()
//
//        // Given
//        var result = 0
//
//        // When
//        testCoroutineScope.launch {
//            delay(10000L) // 10초간 대기
//            result = 1
//            delay(10000L) // 10초간 대기
//            result = 2
//        }
//
//        testCoroutineScope.advanceUntilIdle()
//        assertEquals(2, result)
//    }
//
//    @Test
//    fun `runTest() 사용`() {
//        // Given
//        var result = 0
//
//        // When
//        runTest {
//            delay(10000L) // 10초간 대기
//            result = 1
//            delay(10000L) // 10초간 대기
//            result = 2
//        }
//
//        // Then
//        assertEquals(2, result)
//    }
//
//    @Test
//    fun `runTest() 로 테스트 감싸기`() = runTest { // this: TestScope
//        // Given
//        var result = 0
//
//        // When
//        delay(10000L) // 10초간 대기
//        result = 1
//        delay(10000L) // 10초간 대기
//        result = 2
//
//        // Then
//        assertEquals(2, result)
//    }

    @Test
    fun `runTest() 내부에서 가상 시간 확인`() = runTest {
        delay(1000L)
        println("가상 시간: ${this.currentTime}ms")
        delay(1000L)
        println("가상 시간: ${this.currentTime}ms")
    }

    @Test
    fun `runTest() 내부에서 advanceUntilIdle() 사용하기`() = runTest { // this: TestScope
        var result = 0

        launch {
            delay(1000L)
            result = 1
        }

        // 가상 시간: 0ms, result: 0
        println("가상 시간: ${this.currentTime}ms, result: $result")

        advanceUntilIdle()

        // 가상 시간: 1000ms, result: 1
        println("가상 시간: ${this.currentTime}ms, result: $result")
    }

    @Test
    fun `runTest() 내부에서 join() 사용하기`() = runTest {
        var result = 0

        launch {
            delay(1000L)
            result = 1
        }.join()

        // 가상 시간: 1000ms, result: 1
        println("가상 시간: ${this.currentTime}ms, result: $result")
    }
}