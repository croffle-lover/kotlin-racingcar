package racingcar.model

data class TryCounts(
    private var tryCounts: Int = 0
) {
    fun setTryCounts(number: Int) {
        tryCounts = number
    }

    fun getTryCounts(): Int {
        return tryCounts
    }
}