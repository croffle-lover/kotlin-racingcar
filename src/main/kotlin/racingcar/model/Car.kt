package racingcar.model

private const val MOVE_POINT = 4
private const val LONGER_THAN_5 = " : 자동차 이름은 5자를 초과할 수 없습니다."

class Car(val name: String) {
    init {
        require(name.length <= 5) { name + LONGER_THAN_5 }
    }

    var position: Int = 0
        private set

    fun move(value: Int) {
        if (value >= MOVE_POINT) {
            position++
        }
    }
}