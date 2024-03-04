package racingcar.view

import racingcar.model.Car

private const val MOVE_RESULT = "실행 결과"
private const val FINAL_WINNER = "최종 우승자: "
private const val ONE_STEP = "-"

object OutputView {

    fun informAboutPrintingResult() {
        println(MOVE_RESULT)
    }

    fun printPlayResult(cars: List<Car>) {
        for(car in cars) {
            print("${car.name} : ")
            repeat(car.position) {
                print(ONE_STEP)
            }
        }
        println()
    }

    fun printWinners(winners: List<Car>) {
        val winnerNames = winners.joinToString(", ") { it.name }
        println(FINAL_WINNER + winnerNames)
    }
}