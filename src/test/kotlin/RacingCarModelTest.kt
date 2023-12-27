import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RacingCarModelTest {
    @Test
    fun `properties test` () {
        val racingCarModel = RacingCarModel("rla", 5)
        assertEquals("rla", racingCarModel.carName)
        assertEquals(5, racingCarModel.moveForward)
    }

    @Test
    fun `toRacingPositionModel 전환 기능 확인` () {
        val racingCarModel = RacingCarModel("rla", 5)
        val racingPositionModel = racingCarModel.toRacingPositionModel()
        assertEquals("rla", racingPositionModel.carName)
        assertEquals("-----", racingPositionModel.carPosition)
    }
}