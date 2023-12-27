import utils.BestDriverDeterminant
import utils.StringToCarMapper

class RacingCarViewModel(private val repository: RacingCarRepository) {
    fun setData(cars: String, round: Int){
        repository.setRounds(round)
        repository.setCarList(StringToCarMapper.convertStringToCarList(cars))
    }
    fun checkTermination(): Boolean = repository.checkGameOver()
    fun executeRounds() {
        repository.executeRoundMovement()
    }
    fun getCarPosition(): List<RacingPositionModel> {
        return repository.getCarPositionState().map { it.toRacingPositionModel() }
    }
    fun determineBestDriver(): List<String> {
        return BestDriverDeterminant.determineBestDriver(repository.getCarPositionState())
    }
}