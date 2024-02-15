package racingcar.model

private const val MORE_THAN_ONE_CAR = "자동차는 두 대 이상 이름을 입력해야 합니다."

object Race {
    var cars: MutableList<Car> = mutableListOf()
        private set
    fun addCarToRace(car: Car) {
        cars.add(car)
    }

    fun playOneRound(): List<Car> {
        for (car in cars) {
            val randomNumber = RandomNumber.makeRandomNumber()
            car.move(randomNumber)
        }

        return cars
    }

    fun getWinner(): List<Car> {
        val maxPosition = cars.maxBy { it.position }.position

        return cars.filter { it.position == maxPosition }
    }

    fun validateRaceInput(carNames: List<String>): List<String> {
        if (carNames.isEmpty() || carNames.size < 2 || carNames.contains("")) {
            println(MORE_THAN_ONE_CAR)
            return emptyList()
        }
        return carNames
    }
}