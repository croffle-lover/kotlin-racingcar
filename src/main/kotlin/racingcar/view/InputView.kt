package racingcar.view

import racingcar.controller.Validations

const val CAR_NAMES_PLEASE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
const val TRY_COUNTS_PLEASE = "시도할 횟수는 몇 회인가요?"

object InputView{
    fun readCarNames(): List<String>? {
        println(CAR_NAMES_PLEASE)
        val carNamesInput = readlnOrNull()

        Validations.carNamesInput(carNamesInput)

        return carNamesInput?.trim()?.split(',')
    }

    fun readTryCounts(): Int {
        println(TRY_COUNTS_PLEASE)
        val tryCountsInput = readlnOrNull()

        Validations.tryCountsInput(tryCountsInput)

        return tryCountsInput!!.toInt()
    }
}