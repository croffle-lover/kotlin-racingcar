package racingcar.controller

import racingcar.model.Car
import racingcar.model.Race
import racingcar.model.TryCounts
import racingcar.view.InputView
import racingcar.view.OutputView
import kotlin.random.Random

private const val RANDOM_RANGE = 10

object GameManager {
    private val raceList = Race()
    private val tryCounts = TryCounts()
    private val outputView = OutputView()

    fun setGame() {
        val carNamesInput = InputView.readCarNames()
        carNamesInput?.let { setCars(it) }

        val tryCountsInput = InputView.readTryCounts()
        tryCounts.tryCounts = tryCountsInput
    }

    private fun setCars(carNames: List<String>) {
        for (carName in carNames) {
            val car = Car(carName, 0)
            raceList.addCarList(car)
        }
    }


    fun startGame() {
        outputView.startPrintEachResult()

        val tryCounts = tryCounts.tryCounts
        repeat(tryCounts) {
            playOneRound()
            printPlayResult()
        }
    }

    fun playOneRound() {
        val carList = raceList.cars
        for (car in carList) {
            val rand = Random.nextInt(RANDOM_RANGE)
            car.updatePosition = rand
        }
    }

    private fun printPlayResult() {
        val carList = raceList.cars
        for (car in carList) {
            val carName = car.name
            val position = car.position
            outputView.printCarResult(carName, position)
            println()
        }
    }


    fun getWinner() {
        val carList = raceList.cars
        val maxPosition = carList.maxBy { it.position }.position

        for (car in carList) {
            val carName = car.name
            val position = car.position

            if (position == maxPosition) {
                raceList.addWinnerList(carName)
            }
        }

        outputView.printWinners()
    }
}