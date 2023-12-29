package racingcar.domain

import racingcar.ui.InputView as INPUT

class GameManager {
    companion object {
        fun startGame() {
            val carNames = INPUT.readCarNames()
            val tryCounts = INPUT.readTryCounts()
        }
    }
}