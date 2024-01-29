/**
 *  [ 효율성 ]
 *  - 메모리: 14640KB
 *  - 시간 : 120ms
 */

import java.util.*

fun main() {
    val num = readln().toInt()

    for (i in 0 until num) {
        val stack = Stack<Char>()
        val readln = readln()

        try {
            for (c in readln) if (c == '(') stack.push(c) else stack.pop()
            println(if (stack.size > 0) "NO" else "YES")
        } catch (e: Exception) {
            println("NO")
        }
    }
}
