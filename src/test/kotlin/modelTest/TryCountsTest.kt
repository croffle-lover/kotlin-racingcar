package modelTest

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.model.TryCounts

private const val NOT_A_NUMBER = 0

class TryCountsTest {
    @Test
    fun `게임의 시도 횟수를 가진다`() {
        //given
        val tryCountsInput = 5

        //when
        TryCounts.setTryCounts(tryCountsInput)

        //then
        assertThat(TryCounts.tryCounts).isEqualTo(5)
    }

    @Test
    fun `시도 횟수 숫자로 입력받는다`() {
        //given
        val tryCountsInput ="세 번"

        //when
        val tryCounts = TryCounts.validateTryCounts(tryCountsInput)

        //then
        assertThat(tryCounts).isEqualTo(NOT_A_NUMBER)
    }
}