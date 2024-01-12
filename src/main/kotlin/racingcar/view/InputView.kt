package racingcar.view

import racingcar.model.Car
import racingcar.model.TryCounts

private const val CAR_NAMES_PLEASE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
private const val TRY_COUNTS_PLEASE = "시도할 횟수는 몇 회인가요?"

object InputView{
    private val car = Car("",0)
    private val tryCounts = TryCounts()

    fun readCarNames(): List<String>? {
        println(CAR_NAMES_PLEASE)
        val carNamesInput = readlnOrNull()

        car.carNamesInput(carNamesInput)

        return carNamesInput?.trim()?.split(',')
    }

    fun readTryCounts(): Int {
        println(TRY_COUNTS_PLEASE)
        val tryCountsInput = readlnOrNull()

        tryCounts.tryCountsInput(tryCountsInput)

        return tryCountsInput!!.toInt()
    }
}