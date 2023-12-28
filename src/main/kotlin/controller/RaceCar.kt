package controller

import model.Judgment
import model.Round
import view.InputView
import view.OutputView

class RaceCar {
    private val outputView = OutputView()
    private val inputView = InputView()

    fun start() {
        val participants = getRaceParticipantsInput()
        val round = getRoundInput()
        val judge = Judgment.of(participants, round)
        displayRaceResult(judge, round)
    }

    private fun getRaceParticipantsInput(): String {
        outputView.printInputRaceCarNames()
        return inputView.getUserInput()
    }

    private fun getRoundInput(): String {
        outputView.printInputNumberOfAttempts()
        return inputView.getUserInput()
    }

    private fun displayRaceResult(judge: Judgment, roundString: String) {
        val raceResult = judge.startRace()
        outputView.printCurrentRaceResult(raceResult, Round.from(roundString))
        outputView.printWinner(judge.getWinner())
    }

}