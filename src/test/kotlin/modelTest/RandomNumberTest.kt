package modelTest

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.model.RandomNumber

class RandomNumberTest {
    @Test
    fun `각 시도의 각 차마다 0에서 9 사이에서 무작위 값을 구한다`() {
        //given

        //when
        val randomNumber = RandomNumber.makeRandomNumber()

        //then
        assertThat(randomNumber).isIn(0, 9)
    }
}