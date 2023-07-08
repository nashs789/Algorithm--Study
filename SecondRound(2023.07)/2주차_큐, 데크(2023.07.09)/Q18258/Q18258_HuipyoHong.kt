/**
 *  [ 효율성 ]
 *  - 메모리: 410504KB
 *  - 시간 : 1260ms
 */

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val sb = StringBuilder()
    val queue: Queue<Int> = LinkedList()

    for (i in 0 until n) {
        val command = br.readLine().split(" ")

        when (command[0]) {
            "push" -> queue.offer(command[1].toInt())
            "pop" -> sb.append(if (queue.isEmpty()) -1 else queue.poll()).append("\n")
            "size" -> sb.append(queue.size).append("\n")
            "empty" -> sb.append(if (queue.isEmpty()) 1 else 0).append("\n")
            "front" -> sb.append(if (queue.isEmpty()) -1 else queue.peek()).append("\n")
            "back" -> sb.append(if (queue.isEmpty()) -1 else queue.last()).append("\n")
        }
    }
    br.close()
    bw.write(sb.toString())
    bw.flush()
    bw.close()
}
