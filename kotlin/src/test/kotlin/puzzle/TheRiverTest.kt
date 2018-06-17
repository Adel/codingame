package puzzle

import org.junit.Test

import org.junit.Assert.*

class TheRiverTest {

    @Test
    fun shouldFindMeetingPoint(){
        assertEquals(47, TheRiver.findMeetingPoint(32,47))
    }
}