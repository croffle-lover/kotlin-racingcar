package racingcar.domain

import racingcar.ui.InputView as INPUT

class GameManager {
    companion object {
        fun startGame() {
            val cars = INPUT.readCarNames()
        }
    }
}