package ui

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.ui.InputView
import racingcar.utils.Messages
import racingcar.utils.Validations
import java.io.ByteArrayInputStream

class InputViewTest {
    /* readCarNames */
    @Test
    fun `test readCarNames with valid input`() {
        // Given
        val inputString = "pobi,woni,jun"
        System.setIn(ByteArrayInputStream(inputString.toByteArray()))

        // When
        val result = InputView.readCarNames()

        // Then
        assert(result == listOf("pobi", "woni", "jun"))
    }
    @Test
    fun `test carInputFormat with valid input`() {
        // Given
        val validInput = "car1,car2,car3"

        // When
        Validations.carNamesInput(validInput)

        // Then: No exception should be thrown
    }

    @Test
    fun `test carInputFormat with null input`() {
        // Given
        val nullInput: String? = null

        // When
        val exception = assertThrows<IllegalArgumentException> {
            Validations.carNamesInput(nullInput)
        }

        // Then
        assert(exception.message == Messages.MORE_THAN_ONE_CAR)
    }

    @Test
    fun `test carInputFormat with less than 2 cars`() {
        // Given
        val inputWithLessThanTwoCars = "car1"

        // When
        val exception = assertThrows<IllegalArgumentException> {
            Validations.carNamesInput(inputWithLessThanTwoCars)
        }

        // Then
        assert(exception.message == Messages.MORE_THAN_ONE_CAR)
    }

    @Test
    fun `test carInputFormat with empty car name`() {
        // Given
        val inputWithEmptyCarName = "car1,car2,"

        // When
        val exception = assertThrows<IllegalArgumentException> {
            Validations.carNamesInput(inputWithEmptyCarName)
        }

        // Then
        assert(exception.message == Messages.ANY_NAME_NEEDED)
    }

    @Test
    fun `test carInputFormat with car name longer than 5 characters`() {
        // Given
        val inputWithLongCarName = "car1,longcarname,car3"

        // When
        val exception = assertThrows<IllegalArgumentException> {
            Validations.carNamesInput(inputWithLongCarName)
        }

        // Then
        assert(exception.message == Messages.NOT_LONGER_THAN_5)
    }


    /* readTryCounts */
    @Test
    fun `test readTryCounts with valid input`() {
        // Given
        System.setIn("3".byteInputStream())

        // When
        val result = InputView.readTryCounts()

        // Then
        assert(result.equals(3))
    }

    @Test
    fun `test readTryCounts with invalid input`() {
        // Given
        System.setIn("notANumber".byteInputStream())

        // When
        val exception = assertThrows<NumberFormatException> {
            InputView.readTryCounts()
        }

        // Then
        assert(exception.message == null) // or any other assertion based on your specific needs
    }
    @Test
    fun `test tryCountsInput with valid input`() {
        // Given
        val validInput = "5"

        // When
        Validations.tryCountsInput(validInput)

        // Then: No exception should be thrown
    }

    @Test
    fun `test tryCountsInput with invalid input`() {
        // Given
        val invalidInput = "notANumber"

        // When
        val exception = assertThrows<IllegalArgumentException> {
            Validations.tryCountsInput(invalidInput)
        }

        // Then
        assert(exception.message == Messages.SHOULD_BE_NUMBER)
    }
}