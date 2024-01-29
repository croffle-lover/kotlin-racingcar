package racingcar.controller

import racingcar.model.Car
import racingcar.model.Race
import racingcar.model.TryCounts
import racingcar.view.InputView
import racingcar.view.OutputView

private const val NOT_A_NUMBER = 0

object GameManager {
    fun setGame() {
        getCarsInput()
        getTryCountsInput()
    }

    private fun getCarsInput() {
        var carNamesInput: List<String> = emptyList()
        while(carNamesInput.isEmpty()) {
            carNamesInput = InputView.readCarNames().trim().split(',')
            carNamesInput = Race.rightRaceInputValidation(carNamesInput)
        }

        for (carName in carNamesInput) {
            val car = Car(carName)
            Race.addCarToRace(car)
        }
    }

    private fun getTryCountsInput() {
        var tryCounts: Int = NOT_A_NUMBER
        while(tryCounts == NOT_A_NUMBER) {
            val tryCountsInput = InputView.readTryCounts()
            tryCounts = TryCounts.rightTryCountsInputValidation(tryCountsInput)
        }

        TryCounts.handleSetTryCounts(tryCounts)
    }
    fun playGame() {
        OutputView.informAboutPrintingResult()

        repeat(TryCounts.tryCounts) {
            val cars = Race.playOneRound()
            OutputView.printPlayResult(cars)
        }

        val winners = Race.getWinner()
        OutputView.printWinners(winners)
    }
}