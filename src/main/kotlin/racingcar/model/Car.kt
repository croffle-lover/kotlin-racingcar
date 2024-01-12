package racingcar.model

data class Car(
    val name: String,
    var position: Int = 0
) {
    var updatePosition = 0
        set(value) {
            handleUpdatePosition(value)
        }

    private fun handleUpdatePosition(value: Int) {
        if (value >= 4) {
            position++
        }
    }
}