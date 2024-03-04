package modelTest

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.model.TryCounts

private const val SHOULD_BE_NUMBER = "시도 횟수는 1 이상의 정수여야 합니다."

class TryCountsTest {
    @Test
    fun `시도 횟수는 1 이상의 정수여야 한다`() {
        //given
        val tryCountsInput ="세 번"

        //when
        val error: IllegalArgumentException = assertThrows { TryCounts(tryCountsInput).validateTryCountsInput() }

        //then
        assertThat(error.message).isEqualTo(SHOULD_BE_NUMBER)
    }
}