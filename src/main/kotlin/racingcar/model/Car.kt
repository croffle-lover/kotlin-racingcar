package racingcar.model

data class Car(
    private val name: String,
    private var position: Int
) {
    fun getName(): String {
        return name
    }

    fun getPosition(): Int {
        return position
    }
    fun updatePosition(newPosition: Int) {
        position = newPosition
    }
}