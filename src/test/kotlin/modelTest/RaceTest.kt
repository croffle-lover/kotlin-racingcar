package modelTest

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.model.Car
import racingcar.model.Race

private const val MOVE_POINT = 4

class RaceTest {
    @Test
    fun `경주에 참여할 자동차는 두 대 이상이어야 한다`() {
        //given
        val race = listOf("hyun")

        //when
        val raceValidation = Race.validateRaceInput(race)

        //then
        assertThat(raceValidation).isEmpty()
    }

    @Test
    fun `경주에 참여하는 자동차들을 목록에 추가할 수 있다`() {
        //given
        val race = Race
        val car1 = Car("hyun")
        val car2 = Car("hy")

        //when
        Race.addCarToRace(car1)
        Race.addCarToRace(car2)

        //then
        assertThat(race.cars).isEqualTo(listOf(car1, car2))
    }

    @Test
    fun `한 시도에 n대의 자동차는 각각 전진 또는 멈출 수 있다`() {
        //given
        val race = Race
        val car1 = Car("hyun")
        val car2 = Car("hy")
        race.addCarToRace(car1)
        race.addCarToRace(car2)

        //when
        repeat(3) {
            car1.move(MOVE_POINT)
        }
        race.playOneRound()

        //then
        assertThat(car1.position).isIn(3, 4)
        assertThat(car2.position).isIn(0, 1)
    }

    @Test
    fun `최종 우승자를 구할 수 있다`() {
        //given
        val race = Race
        val car1 = Car("hyun")
        val car2 = Car("hy")
        race.addCarToRace(car1)
        race.addCarToRace(car2)

        //when
        car1.move(MOVE_POINT)
        val winner = race.getWinner()

        //then
        assertThat(winner).isEqualTo(listOf(car1))
    }
}