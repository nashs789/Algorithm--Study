/**
 *  [ 효율성 ]
 *  - 메모리: 38536KB
 *  - 시간 : 464ms
 */

import java.util.*

fun main() {
    val stack = Stack<Int>()
    val n = readln().toInt()
    val stringList = mutableListOf<String>()
    var position = 1
    var isWrong = false

    for (i in 0 until n) {
        val input = readln().toInt()

        while (position <= input) {
            stack.push(position++)
            stringList.add("+")
        }
        if (stack.peek() == input) {
            stack.pop()
            stringList.add("-")
        } else {
            isWrong = true
        }
    }
    println(if (isWrong) "NO" else stringList.joinToString("\n"))
}
