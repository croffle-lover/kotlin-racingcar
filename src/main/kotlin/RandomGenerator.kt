import kotlin.random.Random

object RandomGenerator {
    fun getRandomNumber():Int = Random.nextInt(0, 9)
}