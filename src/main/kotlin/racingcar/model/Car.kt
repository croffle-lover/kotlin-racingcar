package racingcar.model

import racingcar.view.InputView

private const val MOVE_POINT = 4
private const val MORE_THAN_ONE_CAR = "자동차는 두 대 이상 입력해야 합니다."
private const val ANY_NAME_NEEDED = "자동차 이름은 반드시 입력해야 합니다."
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

    fun carNamesRightInput(carNamesInput: String?): List<String> {
        var carNames = carNamesInput?.trim()?.split(',')

        if (carNamesInput == null || carNames!!.size < 2) {
            println(MORE_THAN_ONE_CAR)
            carNames = listOf()
        }
        if (carNames.contains("")) {
            println(ANY_NAME_NEEDED)
            carNames = listOf()
        }
        if (carNames.any { it.length >= 5 }) {
            println(NOT_LONGER_THAN_5)
            carNames = listOf()
        }

        if (carNames.isEmpty()) {
            InputView.readCarNames()
        }

        return carNames
    }

}