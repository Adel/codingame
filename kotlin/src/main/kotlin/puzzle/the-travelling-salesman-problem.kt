package puzzle

import java.lang.Math.sqrt

data class City(val x: Int, val y: Int) {
    fun distance(that: City) = sqrt(Math.pow((x - that.x).toDouble(), 2.0) + Math.pow((y - that.y).toDouble(), 2.0))
}

fun tspDistance(start: City, cities: List<City>): Long {
    tailrec fun loop(current: City, toVisit: List<City>, acc: Double = 0.0): Double {
        return if (toVisit.isEmpty()) {
            acc + current.distance(start)
        } else {
            val (nearest, distance) =
                    toVisit.map { Pair(it, current.distance(it)) }
                            .minBy { it.second }!!
            loop(nearest, toVisit.filter { it != nearest }, acc + distance)
        }
    }
    return Math.round(loop(start, cities))
}