package racingcar.model

private const val SHOULD_BE_NUMBER = "시도 횟수는 1 이상의 정수여야 합니다."

private const val NOT_A_NUMBER = 0
private const val MINIMUM_TRY_COUNTS = 1

class TryCounts(private val tryCountsInput: String) {
    fun validateTryCountsInput() {
        val tryCounts: Int = tryCountsInput.toIntOrNull() ?: NOT_A_NUMBER
        require(tryCounts >= MINIMUM_TRY_COUNTS) { SHOULD_BE_NUMBER }
    }
}