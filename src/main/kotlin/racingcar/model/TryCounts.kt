package racingcar.model

import racingcar.view.InputView

private const val SHOULD_BE_NUMBER = "시도 횟수는 숫자여야 합니다."

data class TryCounts(
    var tryCounts: Int = 0
) {
    fun tryCountsInput(tryCountsInput: String?) {
        val tryCounts = tryCountsInput?.toIntOrNull()

        if (tryCounts == null) {
            println(SHOULD_BE_NUMBER)
            InputView.readTryCounts()
        }
    }
}