package racingcar.model

class Race {
    private val cars: MutableList<Car> = mutableListOf()
    private val winners: MutableList<String> = mutableListOf()

    fun addCarList(car: Car) {
        cars.add(car)
    }

    fun getCarList(): List<Car> {
        return cars
    }

    fun addWinnerList(winner: String) {
        winners.add(winner)
    }

    fun getWinnerList(): MutableList<String> {
        return winners
    }
}