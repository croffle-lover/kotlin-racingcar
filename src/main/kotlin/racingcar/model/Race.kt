package racingcar.model

data class Race(
    val cars: MutableList<Car> = mutableListOf(),
    val winners: MutableList<String> = mutableListOf()
) {
    fun addCarList(car: Car) {
        cars.add(car)
    }

    fun addWinnerList(winner: String) {
        winners.add(winner)
    }
}