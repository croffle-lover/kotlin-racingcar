package racingcar.utils

import racingcar.utils.Messages as MESSAGE
import racingcar.ui.InputView as INPUT

class Validations {
    companion object {
        fun carInputFormat(carInput: String?) {
            var readAgain = 0
            val carNames = carInput?.trim()?.split(',')

            if (carInput == null || (carNames!!.size < 2 && !carNames.contains(""))) {
                println(MESSAGE.MORE_THAN_ONE_CAR)
                readAgain = 1
            }
            if (carInput != null) {
                if (carNames!!.contains("")) {
                    println(MESSAGE.ANY_NAME_NEEDED)
                    readAgain = 1
                }
                if (carNames.any { it.length >= 5 }) {
                    println(MESSAGE.NOT_LONGER_THAN_5)
                    readAgain = 1
                }
            }

            if (readAgain == 1) {
                INPUT.readCarNames()
            }
        }
    }
}