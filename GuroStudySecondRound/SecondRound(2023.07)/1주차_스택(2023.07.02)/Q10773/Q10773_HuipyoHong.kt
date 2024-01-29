/**
 *  [ 효율성 ]
 *  - 메모리: 22264KB
 *  - 시간 : 280ms
 */

import java.util.*

fun main() {
    val input = readln().toInt()
    val stack = Stack<Int>()

    for (i in 0 until input) {
        val number = readln().toInt()
        
        if (number != 0) stack.push(number) else stack.pop()
    }
    println(stack.sum())
}
