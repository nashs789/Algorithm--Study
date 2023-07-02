/**
 *  [ 효율성 ]
 *  - 메모리: 25112KB
 *  - 시간 : 196ms
 */

import java.util.*

fun main() {
    val (n, k) = readln().split(" ").map(String::toInt)
    val queue: Queue<Int> = LinkedList((1..n).toList())
    val answer = mutableListOf<Int>()

    while (queue.isNotEmpty()) {
        repeat(k - 1) {
            queue.offer(queue.poll())
        }
        answer.add(queue.poll())
    }
    println("<${answer.joinToString(", ")}>")
}
