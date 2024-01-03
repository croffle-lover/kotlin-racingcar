package racingcar.controller

import racingcar.model.Car
import racingcar.model.Race
import racingcar.model.TryCounts
import racingcar.view.InputView
import racingcar.view.OutputView
import kotlin.random.Random

class GameManager {
    companion object {
        private val raceList = Race()
        private val tryCounts = TryCounts()
        private val outputView = OutputView()

        fun setGame() {
            val carNamesInput = InputView.readCarNames()
            carNamesInput?.let { setCars(it) }

            val tryCountsInput = InputView.readTryCounts()
            tryCounts.setTryCounts(tryCountsInput)
        }

        private fun setCars(carNames: List<String>) {
            for(carName in carNames) {
                val car = Car(carName, 0)
                raceList.addCarList(car)
            }
        }


        fun startGame() {
            outputView.startPrintEachResult()

            val tryCounts = tryCounts.getTryCounts()
            repeat(tryCounts) {
                playOneRound()
                printPlayResult()
            }
        }

        fun playOneRound() {
            val carList = raceList.getCarList()
            for(car in carList) {
                val rand = Random.nextInt(10)
                if(rand >= 4) {
                    val originPosition = car.getPosition()
                    car.updatePosition(originPosition)
                }
            }
        }

        private fun printPlayResult() {
            val carList = raceList.getCarList()
            for(car in carList) {
                val carName = car.getName()
                val position = car.getPosition()
                outputView.printCarResult(carName, position)
                outputView.oneRoundOver()
            }
        }


        fun getWinner() {
            val carList = raceList.getCarList()
            val maxPosition = carList.maxBy { it.getPosition() }.getPosition()

            for(car in carList) {
                val carName = car.getName()
                val position = car.getPosition()

                if(position == maxPosition) {
                    raceList.addWinnerList(carName)
                }
            }

            outputView.printWinners()
        }
    }
}