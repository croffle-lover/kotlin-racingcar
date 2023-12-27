import utils.GameOverDeterminant
import utils.MovingDemonstrator
import kotlin.properties.Delegates

class RacingCarRepositoryImpl : RacingCarRepository {
    private lateinit var carList: List<RacingCarModel>
    private var raceRound by Delegates.notNull<Int>()

    override fun setRounds(round: Int) {
        raceRound = round
    }

    override fun setCarList(list: List<RacingCarModel>) {
        carList = list
    }

    override fun checkGameOver(): Boolean {
        return GameOverDeterminant.checkGameOver(raceRound)
    }

    override fun executeRoundMovement() {
        carList = MovingDemonstrator.executeRoundMovement(carList)
        raceRound--
    }

    override fun getCarPositionState(): List<RacingCarModel> = carList
}