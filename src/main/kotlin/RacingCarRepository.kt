interface RacingCarRepository {
    fun setRounds(round: Int)
    fun setCarList(list: List<RacingCarModel>)
    fun checkGameOver(): Boolean
    fun executeRoundMovement()
    fun getCarPositionState(): List<RacingCarModel>
}