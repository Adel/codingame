package puzzle

import java.util.*


fun main(args : Array<String>) {
    val number = Scanner(System.`in`).nextInt()
    val map = mutableMapOf(0 to "0", 1 to "1", -1 to "T")
    var i = 0
    while(!map.contains(number)){
        val curr = Math.pow(3.0, ++i + 0.0).toInt()
        val result = map.flatMap {
            listOf(it.key to "0" + it.value, it.key + curr to "1" + it.value, it.key - curr to "T" + it.value)
        }
        map.putAll(result)
    }
    println(map[number])
}