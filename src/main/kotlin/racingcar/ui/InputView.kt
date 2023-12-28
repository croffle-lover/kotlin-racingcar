package racingcar.ui

import racingcar.utils.Messages as MESSAGE
import racingcar.utils.Validations as VALIDATION

class InputView {
    companion object {
        fun readCarNames(): List<String> {
            println(MESSAGE.CAR_NAMES_PLEASE)
            val carInput = readlnOrNull()

            VALIDATION.carInputFormat(carInput)

            return carInput!!.trim().split(',')
        }
    }
}