package model

class Judgment private constructor( private val participants: Participants, private val round: Round ) {

    private val gameBoard = GameBoard.of(participants.getNamesOfParticipants(), round)

    fun startRace(): GameBoard {
        round.forEach { currentRound -> executeMove(currentRound) }
        return gameBoard
    }

    fun getWinner(): List<CarName> = participants.getCarsWithLongestDistance().map { car -> car.name }

    private fun executeMove(round: Round) {
        participants.getNamesOfParticipants().forEach { carName ->
            if (isAvailableMove()) {
                participants.moveCar(carName)
            }
            gameBoard.recordRaceResult(carName, round, participants.getDistance(carName))
        }
    }

    private fun isAvailableMove(): Boolean {
        val score = RandomGenerator.getRandomNumber(RANDOM_START_NUMBER, RANDOM_END_NUMBER)
        return score >= MOVING_POINT
    }

    companion object {
        private const val RANDOM_START_NUMBER = 0
        private const val RANDOM_END_NUMBER = 9
        private const val MOVING_POINT = 4

        fun of(participantsString: String, roundString: String): Judgment {
            val participants = Participants.from(participantsString)
            val round = Round.from(roundString)
            return Judgment(participants, round)
        }
    }
}