package puzzle

object TheRiver {
    @JvmStatic
    fun main(args: Array<String>) {

    }

    fun getNext(n: Long): Long = n + n.toString().sumBy { c -> c.toString().toInt() }

    fun findMeetingPoint(x: Long, y: Long): Long =
            if (x == y) x
            else findMeetingPoint(if (x < y) getNext(x) else x, if (y < x) getNext(y) else y)

}