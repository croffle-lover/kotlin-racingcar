package racingcar.controller

import racingcar.view.InputView

private const val MORE_THAN_ONE_CAR = "자동차는 두 대 이상 입력해야 합니다."
private const val ANY_NAME_NEEDED = "자동차 이름은 반드시 입력해야 합니다."
private const val NOT_LONGER_THAN_5 = "자동차 이름은 5자를 초과할 수 없습니다."
private const val SHOULD_BE_NUMBER = "시도 횟수는 숫자여야 합니다."

class Validations {
    companion object {
        fun carNamesInput(carNamesInput: String?) {
            var readAgain = 0
            val carNames = carNamesInput?.trim()?.split(',')

            if (carNamesInput == null || carNames!!.size < 2) {
                println(MORE_THAN_ONE_CAR)
                readAgain = 1
            }
            if (carNames?.contains("") == true) {
                println(ANY_NAME_NEEDED)
                readAgain = 1
            }
            if (carNames?.any { it.length >= 5 } == true) {
                println(NOT_LONGER_THAN_5)
                readAgain = 1
            }

            if (readAgain == 1) {
                InputView.readCarNames()
            }
        }

        fun tryCountsInput(tryCountsInput: String?) {
            val tryCounts = tryCountsInput?.toIntOrNull()

            if (tryCounts == null) {
                println(SHOULD_BE_NUMBER)
                InputView.readTryCounts()
            }
        }
    }
}