import utils.StringToCarMapper

class RacingCarViewModel(private val repository: RacingCarRepository) {
    fun setData(cars: String, round: Int){
        repository.setRounds(round)
        repository.setCarList(StringToCarMapper.convertStringToCarList(cars))
    }
}