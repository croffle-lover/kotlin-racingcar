package racingcar.model

import racingcar.view.InputView

private const val SHOULD_BE_NUMBER = "시도 횟수는 숫자여야 합니다."

object TryCounts {
    var tryCounts: Int = 0
        private set(value) {
            setTryCounts(value)
        }

    fun setTryCounts(value: Int) {
        tryCounts = value
    }

    fun tryCountsRightInput(tryCountsInput: String?): Int {
        val tryCounts = tryCountsInput?.toIntOrNull() ?: 0

        if (tryCounts == 0) {
            println(SHOULD_BE_NUMBER)
            InputView.readTryCounts()
        }

        return tryCounts
    }
}