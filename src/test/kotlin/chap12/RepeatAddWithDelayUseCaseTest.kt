package chap12

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

class RepeatAddWithDelayUseCaseTest {
    @Test
    fun `runBlocking_100번 더하면 100이 반환된다`() = runBlocking {
        // Given
        val repeatAddUseCase = RepeatAddWithDelayUseCase()

        // When
        val time = measureTimeMillis {
            val result = repeatAddUseCase.add(100)

            // Then
            assertEquals(100, result)
        }
        println("테스트 소요 시간: ${time}ms") // 실제 소요 시간 측정
    }
}