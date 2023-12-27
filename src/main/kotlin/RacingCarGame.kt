import utils.Exceptions
import utils.Instructions


class RacingCarGame {
    private val repository: RacingCarRepository = RacingCarRepositoryImpl()
    private val viewModel = RacingCarViewModel(repository)
    fun run() {
        println(Instructions.MESSAGE_INPUT_CAR_NAMES)
        val inputCarNames = readLine()
        Exceptions.checkCarNamesValidation(inputCarNames)

        println(Instructions.MESSAGE_INPUT_ROUND_NUMBER_OF_ATTEMPTS)
        val inputRounds = readLine()
        Exceptions.checkRoundTrialValidation(inputRounds)

        viewModel.setData(inputCarNames!!, inputRounds!!.toInt())

    }
}