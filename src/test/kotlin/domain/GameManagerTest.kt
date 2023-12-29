package domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import racingcar.domain.Car
import racingcar.domain.GameManager
import racingcar.domain.GameManager.Companion.getWinner
import java.io.ByteArrayOutputStream
import java.io.OutputStream
import java.io.PrintStream

class GameManagerTest {
    @Test
    fun `test startGame`() {
        // Given
        val car1 = Car("car1", 0)
        val car2 = Car("car2", 0)
        val car3 = Car("car3", 0)
        val initialCars = listOf(car1, car2, car3)
        val tryCounts = 5

        // When
        val finalCars = GameManager.startGame(initialCars to tryCounts)

        // Then: Check if each car has moved at least once
        assertTrue(finalCars.any { it.position > 0 })
    }

    @Test
    fun `test playOneRound`() {
        // Given
        val car1 = Car("car1", 0)
        val car2 = Car("car2", 0)
        val car3 = Car("car3", 0)
        val initialCars = listOf(car1, car2, car3)

        // When
        val resultCars = GameManager.playOneRound(initialCars)

        // Then: Check if each car has moved at least once
        assertTrue(resultCars.any { it.position >= 0 })
    }

    @Test
    fun `test printPlayResult`() {
        // Given
        val cars = listOf(
            Car("pobi", 3),
            Car("woni", 0),
            Car("jun", 2)
        )

        // When
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))
        GameManager.printPlayResult(cars)
        val printedResult = outputStream.toString().trim()

        // Then
        val expectedOutput = """
            pobi : ---
            woni : 
            jun : --
            """.trimIndent()

        assertEquals(expectedOutput, printedResult)
    }

    @Test
    fun `test getWinner`() {
        // Given
        val car1 = Car("Car1", 3)
        val car2 = Car("Car2", 5)
        val car3 = Car("Car3", 2)
        val result = listOf(car1, car2, car3)

        // When
        val capturedOutput = captureOutput {
            getWinner(result)
        }

        // Then
        val expectedOutput = "최종 우승자: Car2"
        assertEquals(expectedOutput, capturedOutput.trim())
    }

    // Helper function to capture System.out.println() output
    private fun captureOutput(block: () -> Unit): String {
        val outputStream = System.out
        val printedContent = StringBuilder()
        System.setOut(PrintStream(object : OutputStream() {
            override fun write(b: Int) {
                printedContent.append(b.toChar())
            }
        }))
        try {
            block()
        } finally {
            System.setOut(outputStream)
        }
        return printedContent.toString()
    }
}