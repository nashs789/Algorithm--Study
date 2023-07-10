/**
 *  [ 효율성 ]
 *  - 메모리: 33664KB
 *  - 시간 : 3916ms
 */

import java.util.*
import kotlin.math.*

fun main() {
    val n = readln()
    val numbers = readln().split(" ").map(String::toInt)
    val operators = readln().split(" ")
        .map(String::toInt)
        .flatMapIndexed { index, i ->
            when (index) {
                0 -> "+"
                1 -> "-"
                2 -> "×"
                3 -> "÷"
                else -> ""
            }
                .repeat(i)
                .split("")
                .filter(String::isNotEmpty)
        }
    val stack = Stack<Int>()
    var (maxVar, minVar) = intArrayOf(Int.MIN_VALUE, Int.MAX_VALUE)
    val backTracking = object : Function0<Unit> {
        override fun invoke() {
            for (i in operators.indices) {
                if (stack.contains(i)) continue
                stack.push(i)
                if (stack.size - 1 != operators.size - 1) {
                    invoke()
                } else {
                    val result = calculation(numbers, operators, stack)
                    maxVar = max(maxVar, result)
                    minVar = min(minVar, result)
                }
                stack.pop()
            }
        }
    }

    backTracking()
    println(maxVar)
    println(minVar)
}

private fun calculation(ints: List<Int>, operators: List<String>, indices: List<Int>): Int {
    var result = ints[0]

    for (i in indices.indices) {
        when (operators[indices[i]]) {
            "+" -> result += ints[i + 1]
            "-" -> result -= ints[i + 1]
            "×" -> result *= ints[i + 1]
            "÷" -> result /= ints[i + 1]
        }
    }
    return result
}
