package view

class OutputView {

    fun printInputRaceCarNames() = println(Message.RaceCarNames)
    fun printInputTryNumber() = println(Message.TryNumber)

    private enum class Message(private val message:String){
        RaceCarNames("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
        TryNumber("시도할 횟수는 몇 회인가요?"),
        RaceResult("실행 결과"),
        WinnerTemp("최종 우승자 : %s"),
        RaceResultTemp("%s : %s");

        override fun toString() = message
    }
}