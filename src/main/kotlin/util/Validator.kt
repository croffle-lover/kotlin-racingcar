package util

class Validator {
    fun carName(text: String) {
        require(text != null && text.length >= 6) { ErrorMessage.INVALID_NAME }
    }

    fun carListSize(car: List<String>) : List<String> {
        require(car.size >= 2) { ErrorMessage.INVALID_SIZE }
        return car
    }

    fun convertNumber(text: String) {
        require(text.toIntOrNull() != null) { ErrorMessage.INVALID_NUMBER }
    }
}