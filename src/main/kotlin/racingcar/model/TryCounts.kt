package racingcar.model

private const val SHOULD_BE_NUMBER = "시도 횟수는 숫자여야 합니다."

private const val NOT_A_NUMBER = 0
private const val MINIMUM_TRY_COUNTS = 1

object TryCounts {
    var tryCounts: Int = 0
        private set

    fun setTryCounts(value: Int) {
        tryCounts = value
    }

    fun validateTryCounts(tryCountsInput: String): Int {
        val tryCounts = tryCountsInput.toIntOrNull() ?: NOT_A_NUMBER
        if (tryCounts < MINIMUM_TRY_COUNTS) {
            println(SHOULD_BE_NUMBER)
            return NOT_A_NUMBER
        }
        return tryCounts
    }
}