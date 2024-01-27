package racingcar.model

import kotlin.random.Random

private const val RANDOM_RANGE = 10

object Race {
    private val cars: MutableList<Car> = mutableListOf()
    fun addCarList(car: Car) {
        cars.add(car)
    }

    fun playOneRound(): List<Car> {
        for (car in cars) {
            val randomNumber = Random.nextInt(RANDOM_RANGE)
            car.handleUpdatePosition(randomNumber)
        }

        return cars
    }


    fun getWinner(): List<Car> {
        val maxPosition = cars.maxBy { it.position }.position

        return cars.filter { it.position == maxPosition }
    }
}