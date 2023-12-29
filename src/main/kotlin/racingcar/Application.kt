package racingcar

import racingcar.domain.GameManager as GAME

fun main() {
    val gameSet = GAME.setGame()
    val result = GAME.startGame(gameSet)
    GAME.getWinner(result)
}