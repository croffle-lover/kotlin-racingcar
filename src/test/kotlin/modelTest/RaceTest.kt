package modelTest

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import racingcar.model.NumberGenerator
import racingcar.model.Race

private const val MOVE_POINT = 4

class RaceTest {
    @Test
    fun `경주에 참여할 자동차는 두 대 이상이어야 한다`() {
        //given
        val cars = "hyun"

        //when
        val raceValidation = Race(cars).validateRaceInput()

        //then
        assertThat(raceValidation).isEmpty()
    }

    @Test
    fun `여러 대의 자동차 이름은 쉼표(,)를 기준으로 구분한다`() {
        //given
        val cars = "hyun, hy, un"

        //when
        val race = Race(cars)

        //then
        assertThat(race.cars.map { it.name }).isEqualTo(listOf("hyun", "hy", "un"))
    }

    @Test
    fun `한 시도에 n대의 자동차는 각각 전진 또는 멈출 수 있다`() {
        //given
        val cars = "hyun, hy"
        val race = Race(cars)

        //when
        race.playOneRound(object: NumberGenerator{
            override fun generateRandomNumber(): Int {
                return MOVE_POINT
            }
        })

        //then
        assertAll(
            { assertThat(race.cars.first().position).isEqualTo(1) },
            { assertThat(race.cars.last().position).isEqualTo(1) }
        )
    }

    @Test
    fun `최종 우승자를 구할 수 있다`() {
        //given
        val cars = "hyun, hy"
        val race = Race(cars)

        //when
        race.cars.first().move(MOVE_POINT)
        val winner = race.getWinner()

        //then
        assertThat(winner).isEqualTo(race.cars.first().name)
    }
}