package view

import model.Car

class OutputView {
    fun printGreeting() {
        println(GREETING_TEXT)
    }

    fun printTime() {
        println(TIME_TEXT)
    }

    fun printResult() {
        println()
        println(RESULT_TEXT)
    }

    fun printResultRun(car: List<Car>) {
        car.forEach { println(it.getName() + RUNNING_COLON + RUNNING.repeat(it.getPosition())) }
        println()
    }


    fun printWinner(text: List<String>) {
        println(WINNER_TEXT + text.joinToString(WINNER_SEPERATOR))
    }

    companion object {
        const val GREETING_TEXT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        const val TIME_TEXT = "시도할 횟수는 몇 회인가요?"
        const val RESULT_TEXT = "실행결과"
        const val WINNER_TEXT = "최종 우승자:"
        const val WINNER_SEPERATOR = ","
        const val RUNNING = "-"
        const val RUNNING_COLON = " : "

    }
}