data class RacingCarModel(val carName: String, val moveForward: Int)

fun RacingCarModel.toRacingPositionModel(): RacingPositionModel {
    return RacingPositionModel(carName = carName, carPosition = "-".repeat(moveForward))
}