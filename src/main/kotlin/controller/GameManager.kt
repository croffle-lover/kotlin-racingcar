package controller

import model.Car
import view.InputView
import view.OutputView
import java.util.Random

class GameManager {


    fun run() {
        inputCar()
        inputTime()
        OutputView().printResult()
        gameStart()
        calculateWinner()
        OutputView().printWinner(winner)
    }

    private fun <T> handleInputException(action: () -> T): T {
        return try {
            action()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            handleInputException(action)
        } catch (e: IndexOutOfBoundsException) {
            println(e.message)
            handleInputException(action)
        }
    }

    private fun inputCar() {
        OutputView().printGreeting()
        handleInputException { InputView().carName().forEach { carList.add(Car(it)) } }
    }

    private fun inputTime() {
        OutputView().printTime()
        handleInputException { time = InputView().time() }
    }

    private fun gameStart() {
        for (i in 1..time) {
            carList.forEach {
                it.upDatePosition(running())
            }
            OutputView().printResultRun(carList)
        }

    }

    private fun running(): Int {
        var random = Random()
        if (random.nextInt(RANDOM_BOUND) >= MOVE_BOUND) return AMOUNT_MOVE
        return DONT_MOVE
    }

    private fun calculateWinner() {
        var max = 0
        carList.forEach {
            if (max <= it.getPosition()) max = it.getPosition()
        }
        carList.forEach {
            if (it.getPosition() == max) winner.add(it.getName())
        }
    }

    companion object {
        val carList = mutableListOf<Car>()
        var time = 0
        val winner = mutableListOf<String>()
        const val RANDOM_BOUND = 10
        const val MOVE_BOUND = 4
        const val AMOUNT_MOVE = 1
        const val DONT_MOVE = 0
    }

}