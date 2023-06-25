/**
 *  [ 효율성 ]
 *  - 메모리: 24296KB
 *  - 시간 : 400ms
 */

import java.util.*

fun main() {
    while (true) {
        val input = readln()
        val stack = Stack<Char>()
        var isTrue = true

        if (input == ".") break
        for (c in input) {
            try {
                when (c) {
                    '(', '[' -> stack.push(c)
                    ')' -> if (stack.peek() == '(') stack.pop() else isTrue = false
                    ']' -> if (stack.peek() == '[') stack.pop() else isTrue = false
                }
            } catch (e: Exception) {
                isTrue = false
                break
            }
        }
        println(if (stack.isEmpty() && isTrue) "yes" else "no")
    }
}
