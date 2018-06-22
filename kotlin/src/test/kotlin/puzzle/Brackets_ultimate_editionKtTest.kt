package puzzle

import org.junit.Test

import org.junit.Assert.*

class Brackets_ultimate_editionKtTest {

    @Test
    fun isValid() {
        assertEquals(1, puzzle.isValid("<{[(abc(]}>"))
        assertEquals(0, puzzle.isValid("{([]){}()}"))
        assertEquals(-1, puzzle.isValid("{([{S}]]6K[()]}"))
    }
}