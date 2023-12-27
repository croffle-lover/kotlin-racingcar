package utils

import RacingCarModel
import kotlin.random.Random

object MovingDemonstrator {
    fun executeRoundMovement(carList: List<RacingCarModel>): List<RacingCarModel> {
        val renewalCarList = mutableListOf<RacingCarModel>()

        for (car in carList) {
            val randomNumber = Random.nextInt(10)

            var movingFlag = false
            if (randomNumber >= 4) {
                movingFlag = true
            }

            val renewalCar = if (movingFlag) {
                RacingCarModel(car.carName, car.moveForward + 1)
            } else {
                RacingCarModel(car.carName, car.moveForward)
            }
            renewalCarList.add(renewalCar)
        }

        return renewalCarList
    }
}