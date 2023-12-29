package racingcar.utils

import racingcar.ui.InputView as INPUT
import racingcar.utils.Messages as MESSAGE

class Validations {
    companion object {
        fun carNamesInput(carNamesInput: String?) {
            var readAgain = 0
            val carNames = carNamesInput?.trim()?.split(',')

            if (carNamesInput == null || (carNames!!.size < 2 && !carNames.contains(""))) {
                println(MESSAGE.MORE_THAN_ONE_CAR)
                readAgain = 1
            }
            if (carNamesInput != null) {
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

        fun tryCountsInput(tryCountsInput: String?) {
            val tryCounts = tryCountsInput?.toIntOrNull()

            if (tryCounts == null) {
                println(MESSAGE.SHOULD_BE_NUMBER)
                INPUT.readTryCounts()
            }
        }
    }
}