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

        println()
        println(Instructions.MESSAGE_GAME_RESULT_SENTENCE)

        while (true) {
            if (viewModel.checkTermination()) break

            viewModel.executeRounds()
            viewModel.getCarPosition().forEach { car -> println("${car.carName} : ${car.carPosition}")}
            println()
        }

        val finalWinner = viewModel.determineBestDriver()

        if (finalWinner.size == 1) {
            println(Instructions.MESSAGE_FINAL_WINNER + finalWinner[0])
        } else {
            println(Instructions.MESSAGE_FINAL_WINNER + finalWinner.joinToString(", "))
        }
    }
}