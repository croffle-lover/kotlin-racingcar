package racingcar.controller

import racingcar.model.MakeRandomNumber
import racingcar.model.NumberGenerator
import racingcar.model.Race
import racingcar.model.TryCounts
import racingcar.view.InputView
import racingcar.view.OutputView

object GameManager {

    fun startGame() {
        val carNames = getCarNamesInput()
        val tryNumber = getTryCountsInput()
        val numberGenerator = MakeRandomNumber

        playGame(Race(carNames), tryNumber, numberGenerator)
    }

    private fun getCarNamesInput(): String {
        val carNamesInput = InputView.readCarNames()

        try {
            Race(carNamesInput).validateRaceInput()
        } catch (_: IllegalArgumentException) {
            getCarNamesInput()
        }

        return carNamesInput
    }

    private fun getTryCountsInput(): Int {
        val tryCountsInput = InputView.readTryCounts()

        try {
            TryCounts(tryCountsInput).validateTryCountsInput()
        } catch (_: IllegalArgumentException) {
            getTryCountsInput()
        }

        return tryCountsInput.toInt()
    }
    private fun playGame(race: Race, tryCounts: Int, numberGenerator: NumberGenerator) {
        OutputView.informAboutPrintingResult()

        repeat(tryCounts) {
            val cars = race.playOneRound(numberGenerator)
            OutputView.printPlayResult(cars)
        }

        val winners = race.getWinner()
        OutputView.printWinners(winners)
    }
}