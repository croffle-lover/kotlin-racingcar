package view

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
        println()
    }

    fun printWinner(text: String) {
        println(WINNER_TEXT + text)
    }

    companion object {
        const val GREETING_TEXT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        const val TIME_TEXT = "시도할 횟수는 몇 회인가요?"
        const val RESULT_TEXT = "실행결과"
        const val WINNER_TEXT = "최종 우승자:"
    }
}