import kotlin.random.Random

object RandomGenerator {
    fun getRandomNumber(startNumber: Int, endNumber: Int):Int = Random.nextInt(startNumber, endNumber)
}