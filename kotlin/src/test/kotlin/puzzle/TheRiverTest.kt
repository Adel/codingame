package puzzle

import org.junit.Test

import org.junit.Assert.*

class TheRiverTest {

    @Test
    fun getNext() {
        assertEquals(0, TheRiver.getNext(0))
        assertEquals(6, TheRiver.getNext(3))
        assertEquals(37, TheRiver.getNext(32))
        assertEquals(47, TheRiver.getNext(37))
    }

    @Test
    fun shouldFindMeetingPoint(){
        assertEquals(47, TheRiver.findMeetingPoint(32,47))
    }
}