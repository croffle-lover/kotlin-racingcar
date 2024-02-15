package racingcar.model

import kotlin.random.Random

private const val RANDOM_RANGE = 10

object RandomNumber {
    fun makeRandomNumber(): Int {
        return Random.nextInt(RANDOM_RANGE)
    }
}