package racingcar.model

import kotlin.random.Random

private const val RANDOM_RANGE = 10

interface NumberGenerator {
    fun generateNumber(): Int
}

object RandomNumber: NumberGenerator {
    override fun generateNumber(): Int {
        return Random.nextInt(RANDOM_RANGE)
    }
}