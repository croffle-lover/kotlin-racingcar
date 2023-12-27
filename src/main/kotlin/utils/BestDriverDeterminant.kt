package utils

import RacingCarModel

object BestDriverDeterminant {
    fun determineBestDriver(cars: List<RacingCarModel>): List<String> {
        val maxPosition = cars.maxBy { it.moveForward }.moveForward
        return cars.filter { it.moveForward == maxPosition }.map { it.carName }
    }
}