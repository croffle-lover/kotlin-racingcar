package utils

object GameOverDeterminant {
    fun checkGameOver(terminationFlag: Int): Boolean {
        return terminationFlag == 0
    }
}