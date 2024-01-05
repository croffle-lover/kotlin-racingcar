package util

enum class ErrorMessage(private val message: String) {
    INVALID_NAME("잘못된 이름입니다. 다시 입력해 주세요."),
    INVALID_SIZE("잘못된 입력입니다. 2개 이상의 이름을 입력해주세요"),
    INVALID_NUMBER("잘못된 입력입니다. 1이상의 자연수로 다시 입력해 주세요.");

    fun getMessage(): String = "[ERROR] $message"
}