package racingcar.model

import racingcar.view.InputView

private const val MOVE_POINT = 4
private const val MORE_THAN_ONE_CAR = "자동차는 두 대 이상 입력해야 합니다."
private const val ANY_NAME_NEEDED = "자동차 이름은 반드시 입력해야 합니다."
private const val NOT_LONGER_THAN_5 = "자동차 이름은 5자를 초과할 수 없습니다."

data class Car(
    val name: String,
    var position: Int = 0
) {
    var updatePosition = 0
        set(value) {
            handleUpdatePosition(value)
        }

    private fun handleUpdatePosition(value: Int) {
        if (value >= MOVE_POINT) {
            position++
        }
    }

    fun carNamesInput(carNamesInput: String?) {
        var readAgain = 0
        val carNames = carNamesInput?.trim()?.split(',')

        if (carNamesInput == null || carNames!!.size < 2) {
            println(MORE_THAN_ONE_CAR)
            readAgain = 1
        }
        if (carNames?.contains("") == true) {
            println(ANY_NAME_NEEDED)
            readAgain = 1
        }
        if (carNames?.any { it.length >= 5 } == true) {
            println(NOT_LONGER_THAN_5)
            readAgain = 1
        }

        if (readAgain == 1) {
            InputView.readCarNames()
        }
    }
}