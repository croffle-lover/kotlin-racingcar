package racingcar.model

private const val MOVE_POINT = 4

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
}