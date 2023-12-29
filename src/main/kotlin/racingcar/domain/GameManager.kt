package racingcar.domain

import racingcar.ui.InputView as INPUT

class GameManager {
    companion object {
        fun setGame() {
            val carNames = INPUT.readCarNames()
            val tryCounts = INPUT.readTryCounts()

            val cars = setCars(carNames)
        }

        private fun setCars(carNames: List<String>): List<Car> {
            return carNames.map { Car(it, 0) }
        }
    }
}

data class Car(val name: String, var position: Int)