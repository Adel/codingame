package puzzle.theriverii

import java.util.*


fun isMeetingPoint(x: Int): Boolean {
    val next = { n: Int -> n + n.toString().sumBy { c -> c.toString().toInt() } }
    var i = x - 1
    while (i > 0 && i >= x - x.toString().length * 9) {
        if (next(i--) == x) {
            return true
        }
    }
    return false
}

fun main(args: Array<String>) {
    val r = Scanner(System.`in`).nextInt()
    println(if (isMeetingPoint(r)) "YES" else "NO")
}