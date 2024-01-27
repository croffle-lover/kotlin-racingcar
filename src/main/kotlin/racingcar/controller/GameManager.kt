package racingcar.controller

import racingcar.model.Car
import racingcar.model.Race
import racingcar.model.TryCounts
import racingcar.view.InputView
import racingcar.view.OutputView

object GameManager {

    fun setGame() {
        val carNamesInput = InputView.readCarNames()
        for (carName in carNamesInput) {
            val car = Car.setCar(carName)
            Race.addCarList(car)
        }

        val tryCountsInput = InputView.readTryCounts()
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