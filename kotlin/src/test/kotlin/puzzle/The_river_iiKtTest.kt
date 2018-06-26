package puzzle

import org.junit.Test
import puzzle.theriverii.isMeetingPoint
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class The_river_iiKtTest {

    @Test
    fun shouldReturnTrueIfMeetingPoint() {
        assertTrue { isMeetingPoint(519) }
    }

    @Test
    fun shouldReturnFalseIfNotMeetingPoint() {
        assertFalse { isMeetingPoint(20) }
    }
}