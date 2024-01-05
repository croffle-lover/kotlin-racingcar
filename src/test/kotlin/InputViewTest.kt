import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import view.InputView

class InputViewTest {

    @Test
    fun `반복 횟수 입력 테스트`() {
        assertThat(InputView("3").time()).isEqualTo(3)
    }

    @ParameterizedTest
    @ValueSource(strings = ["a", "-1", "1.4", "0", "", "\\"])
    fun `반복 횟수 입력 예외 테스트`(text: String) {
        assertThrows<IllegalArgumentException> {
            InputView(text).time()
        }
    }

    @Test
    fun `자동차 이름 입력 테스트`() {
        assertThat(InputView("test1,test2").carName()).isEqualTo(listOf("test1", "test2"))
    }

    @ParameterizedTest
    @ValueSource(strings = ["a", "-1", "1.4", "0", "", "\\", "test1,test2,test10", "test1"])
    fun `자동차 이름 입력 예외 테스트`(text: String) {
        assertThrows<IllegalArgumentException> {
            InputView(text).carName()
        }
    }
}