package utils

object Exceptions {
    fun checkCarNamesValidation(inputCarNames: String?) {
        if (inputCarNames == null) {
            throwIllegalArgumentException()
        } else {
            val carNames = inputCarNames.split(",").map { it.trim() }
            if (carNames.any { it.isBlank() || it.length > 5} || carNames.size < 2) {
                throwIllegalArgumentException()
            }
        }
    }

    fun checkRoundTrialValidation(inputRounds: String?) {
        if (inputRounds == null || !inputRounds.all { it.isDigit() } || inputRounds.toInt() == 0) {
            throwIllegalArgumentException()
        }
    }

    private fun throwIllegalArgumentException() {
        throw IllegalArgumentException(Instructions.ERROR_INPUT_INCORRECTION)
    }
}