package chap12

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class AddUseCaseTestBeforeEach {
    lateinit var addUseCase: AddUseCase

    @BeforeEach
    fun setUp() {
        addUseCase = AddUseCase()
    }

    @Test
    fun `1 더하기 2는 3이다`() {
        val result = addUseCase.add(1, 2)
        assertEquals(result, 3)
    }

    @Test
    fun `-1 더하기 2는 1이다`() {
        val result = addUseCase.add(-1, 2)
        assertEquals(result, 1)
    }
}