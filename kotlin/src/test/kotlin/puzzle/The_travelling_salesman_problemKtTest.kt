package puzzle

import org.junit.Test

import org.junit.Assert.*

class The_travelling_salesman_problemKtTest {

    @Test
    fun tspDistance() {
        val cities = mutableListOf(City(24, 15), City(12, 30), City(4, 3), City(13, 27))
        val start = City(9, 12)
        val distance = tspDistance(start, cities)
        assertEquals(71, distance)
    }

    @Test
    fun test(){
        val N = 5
        repeat(N){}
        val cities = (1..5).map { City(1,1) }.toList()
        println(cities)
    }
}