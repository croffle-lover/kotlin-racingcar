package racingcar.model

import kotlin.random.Random

private const val RANDOM_RANGE = 10

fun interface NumberGenerator {
    fun generateRandomNumber(): Int
}

object MakeRandomNumber: NumberGenerator {
    override fun generateRandomNumber(): Int {
        return Random.nextInt(RANDOM_RANGE)
    }
}