package racingcar.controller

import racingcar.model.Race
import racingcar.model.TryCounts
import racingcar.view.InputView
import racingcar.view.OutputView

private const val NOT_A_NUMBER = 0

object GameManager {
    private var carNames: String = ""

    fun startGame() {
        setGame()
        playGame(Race(carNames))
    }

    private fun setGame() {
        getCarsInput()
        getTryCountsInput()
    }

    private fun getCarsInput() {
        while(carNames == "") {
            val carNamesInput = InputView.readCarNames()
            carNames = Race(carNamesInput).validateRaceInput()
        }
    }

    private fun getTryCountsInput() {
        var tryCounts: Int = NOT_A_NUMBER
        while(tryCounts == NOT_A_NUMBER) {
            val tryCountsInput = InputView.readTryCounts()
            tryCounts = TryCounts.validateTryCounts(tryCountsInput)
        }

        TryCounts.setTryCounts(tryCounts)
    }
    private fun playGame(race: Race) {
        OutputView.informAboutPrintingResult()

        repeat(TryCounts.tryCounts) {
            val cars = race.playOneRound()
            OutputView.printPlayResult(cars)
        }

        val winners = race.getWinner()
        OutputView.printWinners(winners)
    }
}