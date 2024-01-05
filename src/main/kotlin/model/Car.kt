package model

data class Car(
    private val name: String,
    private var position: Int = 0
) {

    fun getPosition(): Int {
        return position
    }

    fun getName(): String {
        return name
    }

    fun upDatePosition(move: Int) {
        position += move
    }

}