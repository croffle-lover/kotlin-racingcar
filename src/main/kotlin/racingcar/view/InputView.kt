package racingcar.view

private const val CAR_NAMES_PLEASE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
private const val TRY_COUNTS_PLEASE = "시도할 횟수는 몇 회인가요?"

object InputView{

    fun readCarNames(): String {
        println(CAR_NAMES_PLEASE)
        val carNamesInput = readlnOrNull() ?: ""

        return carNamesInput
    }

    fun readTryCounts(): String {
        println(TRY_COUNTS_PLEASE)
        val tryCountsInput = readlnOrNull() ?: ""

        return tryCountsInput
    }
}