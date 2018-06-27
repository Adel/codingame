package puzzle

import org.junit.Test

import org.junit.Assert.*

class Rugby_scoreKtTest {

    @Test
    fun combinations() {
        assertEquals(listOf(Triple(0, 0, 4), Triple(2, 1, 0)), combinations(12))
    }
}