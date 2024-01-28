package racingcar.model

private const val MOVE_POINT = 4
private const val NOT_LONGER_THAN_5 = "자동차 이름은 5자를 초과할 수 없습니다."

object Car {
    var name: String = "Anonymous"

    var position: Int = 0
        private set(value) {
            handleUpdatePosition(value)
        }

    fun handleUpdatePosition(value: Int) {
        if (value >= MOVE_POINT) {
            position++
        }
    }

    fun setCar(carName: String): Car {
        val car = Car
        car.name = carName
        return car
    }

    fun rightCarInputValidation(carNames: List<String>): List<String> {
        if (carNames.any { it.length >= 5 }) {
            println(NOT_LONGER_THAN_5)
            return emptyList()
        }
        return carNames
    }
}