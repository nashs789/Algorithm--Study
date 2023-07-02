/**
 *  [ 효율성 ]
 *  - 메모리: 24968KB
 *  - 시간 : 208ms
 */

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val deque: Deque<Int> = LinkedList()
    val n = br.readLine().toInt()
    val sb = StringBuilder()

    for (i in 0 until n) {
        val command = br.readLine().split(" ")

        when (command[0]) {
            "push_front" -> deque.addFirst(command[1].toInt())
            "push_back" -> deque.addLast(command[1].toInt())
            "pop_front" -> sb.append(if (deque.size > 0) deque.pollFirst() else -1).append("\n")
            "pop_back" -> sb.append(if (deque.size > 0) deque.pollLast() else -1).append("\n")
            "size" -> sb.append(deque.size).append("\n")
            "empty" -> sb.append(if (deque.isEmpty()) 1 else 0).append("\n")
            "front" -> sb.append(if (deque.size > 0) deque.first else -1).append("\n")
            "back" -> sb.append(if (deque.size > 0) deque.last else -1).append("\n")
        }
    }
    br.close()
    bw.write(sb.toString())
    bw.flush()
    bw.close()
}
