package puzzle

import org.junit.Test

import org.junit.Assert.*

class Brackets_extreme_editionKtTest {

    @Test
    fun valid() {
        assertTrue(puzzle.valid(""))
        assertTrue(puzzle.valid("()"))
        assertTrue(puzzle.valid("{}"))
        assertTrue(puzzle.valid("[]"))
        assertTrue(puzzle.valid("([{}])"))
        assertTrue(puzzle.valid("(Q[AB{CDE}FG]H)T"))
        assertTrue(puzzle.valid("{([]){}()}"))

        assertFalse(puzzle.valid(")("))
        assertFalse(puzzle.valid(")"))
        assertFalse(puzzle.valid("("))
        assertFalse(puzzle.valid("{"))
        assertFalse(puzzle.valid("}"))
        assertFalse(puzzle.valid("}{"))
        assertFalse(puzzle.valid("["))
        assertFalse(puzzle.valid("]"))
        assertFalse(puzzle.valid("]["))
        assertFalse(puzzle.valid("([]{}[{}]"))
    }
}