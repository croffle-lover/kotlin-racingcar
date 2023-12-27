import utils.Exceptions
import utils.Instructions


class RacingCarGame {
    fun run() {
        println(Instructions.MESSAGE_INPUT_CAR_NAMES)
        val inputCarNames = readLine()
        Exceptions.checkCarNamesValidation(inputCarNames)

        println(Instructions.MESSAGE_INPUT_ROUND_NUMBER_OF_ATTEMPTS)
        val inputRounds = readLine()
        Exceptions.checkRoundTrialValidation(inputRounds)
    }
}