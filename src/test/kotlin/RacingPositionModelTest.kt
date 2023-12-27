import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class RacingPositionModelTest {
    @Test
    fun `properties test` () {
        val racingPositionModel = RacingPositionModel("rla", "-----")
        Assertions.assertEquals("rla", racingPositionModel.carName)
        Assertions.assertEquals("-----", racingPositionModel.carPosition)
    }
}