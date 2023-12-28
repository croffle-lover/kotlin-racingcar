package model

class Car(val name: CarName) {
    private var _distance = 0
    val distance: Int get() = _distance
    fun moveForward(): Int = ++_distance
}
@JvmInline
value class CarName(private val value: String) {
    override fun toString(): String = value
}