package racingcar.model

private const val MORE_THAN_ONE_CAR = "자동차는 두 대 이상 이름을 입력해야 합니다."
private const val CAR_NAME_SPLIT_POINT = ','

class Race(private val carNames: String) {
    val cars: List<Car> = carNames.split(CAR_NAME_SPLIT_POINT)
        .map { name -> Car(name.trim())}

    fun playOneRound(numberGenerator: NumberGenerator): List<Car> {
        cars.forEach { car ->
            car.move(numberGenerator.generateRandomNumber())
        }

        return cars
    }

    fun getWinner(): List<Car> {
        val maxPosition = cars.maxBy { it.position }.position

        return cars.filter { it.position == maxPosition }
    }

    fun validateRaceInput(): String {
        if (cars.isEmpty() || cars.size < 2 || cars.contains(Car(""))) {
            println(MORE_THAN_ONE_CAR)
            return ""
        }
        return carNames
    }
}