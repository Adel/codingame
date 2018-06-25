package puzzle

enum class Direction(val x: Int, val y: Int) {
    BOTTOM(1, 0), TOP(-1, 0), LEFT(0, -1), RIGHT(0, 1), TOPLEFT(-1, -1), TOPRIGHT(-1, 1), BOTTOMLEFT(1, -1), BOTTOMRIGHT(1, 1)
}

fun findWord(arr: Array<CharArray>, dic: Set<String>): String {
    val height = arr.size
    val width = arr[0].size
    val firstChars = dic.map { it[0] }.toSet()
    val m = Array(height) { BooleanArray(width) }

    //iterate on all letters
    for (i in 0 until height) {
        for (j in 0 until width) {
            if (firstChars.contains(arr[i][j])) {
                //loop on each direction
                for (dir in Direction.values()) {
                    var a = i
                    var b = j
                    var word = ""
                    var positions = listOf<Pair<Int, Int>>()
                    //loop in direction and keep track of all positions
                    while (a in 0 until height && b in 0 until width) {
                        word += arr[a][b]
                        positions += Pair(a, b)
                        if (dic.contains(word)) {
                            positions.forEach { m[it.first][it.second] = true }
                            positions = listOf()
                        }
                        a += dir.x
                        b += dir.y
                    }
                }
            }
        }
    }

    var result = ""
    for (i in 0 until height) {
        for (j in 0 until width) {
            if (!m[i][j]) {
                result += arr[i][j]
            }
        }
    }
    return result
}