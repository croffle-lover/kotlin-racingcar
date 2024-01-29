package modelTest

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.model.Car

private const val MOVE_POINT = 4
private const val MOVED_ONCE = 1

class CarTest {
    @Test
    fun `각 자동차에 이름을 부여할 수 있다`() {
        //given
        val carName = "hyun"

        //when
        val car = Car(carName)

        //then
        assertThat(car.name).isEqualTo(carName)
    }

    @Test
    fun `자동차 이름은 5자를 초과할 수 없다`() {
        //given
        val car = listOf("nuyh_hyun", "hyun")

        //when
        val carValidation = Car("dummy").rightCarInputValidation(car)

        //then
        assertThat(carValidation).isEmpty()
    }

    @Test
    fun `자동차는 무작위 값이 4 이상인 경우 전진한다`() {
        //given
        val car = Car("hyun")

        //when
        car.handleMovePosition(MOVE_POINT)
        car.handleMovePosition(MOVE_POINT - 1)

        //then
        assertThat(car.position).isEqualTo(MOVED_ONCE)
    }

    @Test
    fun `자동차는 자신의 위치를 가진다`() {
        //given
        val car = Car("hyun")

        //when
        repeat(2) {
            car.handleMovePosition(MOVE_POINT)
        }

        //then
        assertThat(car.position).isEqualTo(2)
    }
}