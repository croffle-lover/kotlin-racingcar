package ui

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.utils.Messages
import racingcar.utils.Validations

class InputViewTest {

    @Test
    fun `test carInputFormat with valid input`() {
        // Given
        val validInput = "car1,car2,car3"

        // When
        Validations.carInputFormat(validInput)

        // Then: No exception should be thrown
    }

    @Test
    fun `test carInputFormat with null input`() {
        // Given
        val nullInput: String? = null

        // When
        val exception = assertThrows<IllegalArgumentException> {
            Validations.carInputFormat(nullInput)
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
            Validations.carInputFormat(inputWithLessThanTwoCars)
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
            Validations.carInputFormat(inputWithEmptyCarName)
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
            Validations.carInputFormat(inputWithLongCarName)
        }

        // Then
        assert(exception.message == Messages.NOT_LONGER_THAN_5)
    }
}