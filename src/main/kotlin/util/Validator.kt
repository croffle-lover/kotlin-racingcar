package util

class Validator {
    fun carName(text: String) {
        require(text != null) { ErrorMessage.INVALID_NAME }
    }

    fun carListSize(car: List<String>): List<String> {
        require(car.size >= 2) { ErrorMessage.INVALID_SIZE }
        car.forEach {
            require(it.length <= 5) { ErrorMessage.INVALID_NAME }
        }
        return car
    }

    fun convertNumber(text: String) {
        require(text.toIntOrNull() != null && text.toInt() >= 1) { ErrorMessage.INVALID_NUMBER }
    }
}