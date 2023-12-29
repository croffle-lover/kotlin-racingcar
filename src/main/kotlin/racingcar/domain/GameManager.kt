package racingcar.domain

import kotlin.random.Random
import racingcar.ui.InputView as INPUT
import racingcar.utils.Messages as MESSAGE

data class Car(val name: String, var position: Int)
class GameManager {
    companion object {
        /* setting */
        fun setGame(): Pair<List<Car>, Int> {
            val carNames = INPUT.readCarNames()
            val tryCounts = INPUT.readTryCounts()

            val cars = setCars(carNames)

            return cars to tryCounts
        }

        private fun setCars(carNames: List<String>): List<Car> {
            return carNames.map { Car(it, 0) }
        }

        /* play games */
        fun startGame(gameSet: Pair<List<Car>, Int>): List<Car> {
            var cars = gameSet.first
            val counts = gameSet.second
            println(MESSAGE.MOVE_RESULT)

            repeat(counts) {
                cars = playOneRound(cars)
                printPlayResult(cars)
                println()
            }

            return cars
        }

        fun playOneRound(cars: List<Car>): List<Car> {
            for(car in cars) {
                val rand = Random.nextInt(10)
                if(rand >= 4) {
                    car.position++
                }
            }
            return cars
        }

        fun printPlayResult(cars: List<Car>) {
            for(car in cars) {
                print(car.name + " : ")
                repeat(car.position) {
                    print('-')
                }
                println()
            }
        }

        /* get winner(s) */
        fun getWinner(result: List<Car>) {
            val maxPosition = result.maxBy { it.position }.position
            val winnerList: MutableList<String> = mutableListOf()

            for(car in result) {
                if(car.position == maxPosition) {
                    winnerList.add(car.name)
                }
            }

            val finalWinnerList = winnerList.joinToString(", " )
            println(MESSAGE.FINAL_WINNER + finalWinnerList)
        }
    }
}