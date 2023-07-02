/**
 *  [ 효율성 ]
 *  - 메모리: 30976KB
 *  - 시간 : 288ms
 */

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val stack = Stack<Int>()
    val num = br.readLine().toInt()
    val sb = StringBuilder()

    for (i in 0 until num) {
        val input: String = br.readLine()

        try {
            val command = input.split(" ".toRegex())

            when (command[0]) {
                "push" -> stack.push(command[1].toInt())
                "pop" -> sb.append("${stack.pop()}\n")
                "size" -> sb.append("${stack.size}\n")
                "empty" -> sb.append("${if (stack.isEmpty()) 1 else 0}\n")
                "top" -> sb.append("${stack.peek()}\n")
            }
        } catch (e: Exception) {
            sb.append("-1\n")
        }
    }
    br.close()
    bw.write(sb.toString())
    bw.flush()
    bw.close()
}
