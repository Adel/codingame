package puzzle

operator fun String.times(n: Int) = this.repeat(n)

fun triForce(n: Int, pattern: String = "*"): String {

    val arr = Array(2 * n) { "" }
    for (i in 0 until n) {
        val line = pattern * (2 * i + 1)
        val indent = n - i - 1
        arr[i] = " " * (indent + n) + line
        arr[i + n] = " " * indent + line + " " * (indent * 2 + 1) + line
    }
    return arr.joinToString("\n").replaceFirst(' ', '.')
}

fun main(args: Array<String>) {
    triForce(3).run(::println)
}