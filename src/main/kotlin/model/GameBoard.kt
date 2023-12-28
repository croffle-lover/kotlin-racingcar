package model

class GameBoard private constructor(private val scoresByCarName: Map<CarName, Scores>) {

    fun recordRaceResult(carName: CarName, round: Round, score: Score) {
        val scores = scoresByCarName[carName] ?: throw IllegalArgumentException(Error.InvalidName.message)
        scores.addCurrentScore(round, score)
    }

    fun getScoresByRound(round: Round): List<Pair<CarName, Score>> =
        scoresByCarName.flatMap { (carName, scores) ->
            val score = scores.scoreByRound[round] ?: throw IllegalArgumentException(Error.InvalidRound.message)
            listOf(carName to score)
        }

    companion object {
        fun of(nameOfParticipants: List<CarName>, round: Round): GameBoard {
            val scoresByCarName = nameOfParticipants.associateWith { Scores.from(round) }
            return GameBoard(scoresByCarName)
        }
    }

    internal enum class Error(val message: String) {
        InvalidName("자동차 이름을 확인해주세요."),
        InvalidRound("유효하지 않은 값입니다. 다시 확인해주세요."),
    }
}