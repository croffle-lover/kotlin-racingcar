package racingcar.model

private const val MOVE_POINT = 4
private const val NOT_LONGER_THAN_5 = "자동차 이름은 5자를 초과할 수 없습니다."

class Car(val name: String) {
    fun rightCarInputValidation(carNames: List<String>): List<String> {
        if (carNames.any { it.length >= 5 }) {
            println(NOT_LONGER_THAN_5)
            return emptyList()
        }
        return carNames
    }

    var position: Int = 0
        private set

    fun handleMovePosition(value: Int) {
        if (value >= MOVE_POINT) {
            position++
        }
    }
}