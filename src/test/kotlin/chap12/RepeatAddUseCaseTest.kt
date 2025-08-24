package chap12

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RepeatAddUseCaseTest {
    // 일시 중단 함수는 코루틴 내부에서 실행되어야 하므로 테스트 함수를 runBlocking 함수로 감쌈
    @Test
    fun `100번 더하면 100이 반환된다`() = runBlocking {
        // Given
        val repeatAddUseCase = RepeatAddUseCase()

        // When
        val result = repeatAddUseCase.add(100)

        // Then
        assertEquals(100, result)
    }
}