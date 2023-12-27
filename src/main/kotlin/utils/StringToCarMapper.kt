package utils

import RacingCarModel

object StringToCarMapper {
    fun convertStringToCarList(input: String): List<RacingCarModel> {
        return input.split(",").map { RacingCarModel(carName = it.trim(), moveForward = 0 ) }
    }
}