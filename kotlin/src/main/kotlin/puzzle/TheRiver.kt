package puzzle

object TheRiver {

    fun findMeetingPoint(x: Long, y: Long): Long {
        val next = {n:Long -> n + n.toString().sumBy { c -> c.toString().toInt() }}
        var a = x
        var b = y
        while(a != b){
            a = if (a <b) next(a) else a
            b = if (b < a) next(b) else b
        }
        return a
    }

}