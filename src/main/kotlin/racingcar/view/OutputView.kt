package racingcar.view

import racingcar.model.Race

private const val MOVE_RESULT = "실행 결과"
private const val FINAL_WINNER = "최종 우승자: "
private const val ONE_STEP = "-"

class OutputView {
    private val raceList = Race()

    fun startPrintEachResult() {
        println(MOVE_RESULT)
    }

    fun printCarResult(carName: String, position: Int) {
        print("$carName : ")
        repeat(position) {
            print(ONE_STEP)
        }
        println()
    }

    fun printWinners() {
        val winnerList = raceList.winners
        println(FINAL_WINNER + winnerList.joinToString(", " ))
    }
}