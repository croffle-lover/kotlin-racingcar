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
            carNamesInput = InputView.readCarNames()
            carNamesInput = Race.rightRaceInputValidation(carNamesInput)
            carNamesInput = Car.rightCarInputValidation(carNamesInput)
        }

        for (carName in carNamesInput) {
            val car = Car.setCar(carName)
            Race.addCarList(car)
        }
    }

    private fun getTryCountsInput() {
        var tryCountsInput = NOT_A_NUMBER
        while(tryCountsInput == NOT_A_NUMBER) {
            tryCountsInput = InputView.readTryCounts()
            tryCountsInput = TryCounts.rightTryCountsInputValidation(tryCountsInput)
        }

        TryCounts.setTryCounts(tryCountsInput)
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