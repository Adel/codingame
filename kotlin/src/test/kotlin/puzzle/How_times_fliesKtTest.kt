package puzzle

import org.junit.Test

import org.junit.Assert.*

class How_times_fliesKtTest {

    @Test
    fun getDifference() {
        assertEquals("16 years, total 5844 days", getDifference("01.01.2000", "01.01.2016"))
        assertEquals("1 year, 1 month, total 426 days", getDifference("15.12.2014", "14.02.2016"))
        assertEquals("7 months, total 230 days", getDifference("01.01.2016", "18.08.2016"))
        assertEquals("total 0 days", getDifference("01.01.2016", "01.01.2016"))
    }
}