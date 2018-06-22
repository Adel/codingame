package puzzle.enhanced

import java.util.*
/*
 TODO: works but not good enough
 */
val compatible = mapOf('(' to ')', '[' to ']', '{' to '}', '<' to '>', '>' to '<', '}' to '{', ']' to '[', ')' to '(')
fun isValid(exp: String): Boolean {
    val stack = ArrayDeque<Char>()
    exp.forEach {
        if (it !in "([{}])<>") return@forEach
        else {
            if (stack.isNotEmpty() && it == compatible[stack.peek()]) {
                stack.pop()
            } else {
                stack.push(it)
            }
        }
    }
    val reduced = recurse(stack)
    return reduced.isEmpty()
}

tailrec fun recurse(stack: ArrayDeque<Char>): ArrayDeque<Char> {
    val size = stack.size
    val next = reduceStack(stack)
    return if (size != next.size) recurse(next) else next
}

fun reduceStack(stack: ArrayDeque<Char>): ArrayDeque<Char> {
    val next = ArrayDeque<Char>()
    while (stack.isNotEmpty()) {
        val first = stack.pop()
        if (stack.isNotEmpty() && compatibleChar(stack.peek(), first)) {
            stack.pop()
        } else {
            next.push(first)
        }
    }
    return next
}

fun compatibleChar(a: Char, b: Char) = b.toInt() - a.toInt() in -2..2
