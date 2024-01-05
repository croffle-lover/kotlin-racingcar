package view

import util.Validator

class InputView(private val text: String = readln()) {
    fun carName(): List<String> {
        Validator().carName(text)
        return Validator().carListSize(text.trim().split(delimiterText))
    }

    fun time(): Int {
        return text.toInt()
    }

    companion object {
        const val delimiterText = ","
    }
}