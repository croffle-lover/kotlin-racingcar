package racingcar.ui

import racingcar.utils.Messages as MESSAGE
import racingcar.utils.Validations as VALIDATION

class InputView {
    companion object {
        fun readCarNames(): List<String> {
            println(MESSAGE.CAR_NAMES_PLEASE)
            val carNamesInput = readlnOrNull()

            VALIDATION.carNamesInput(carNamesInput)

            return carNamesInput!!.trim().split(',')
        }

        fun readTryCounts(): Int {
            println(MESSAGE.TRY_COUNTS_PLEASE)
            val tryCountsInput = readlnOrNull()

            VALIDATION.tryCountsInput(tryCountsInput)

            return tryCountsInput!!.toInt()
        }
    }
}