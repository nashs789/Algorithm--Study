/**
 *  [ 효율성 ]
 *  - 메모리: 59720KB
 *  - 시간 : 220ms
 */

import java.util.*

fun main() {
    val n = readln().toInt()
    val queue: Queue<Int> = LinkedList((1..n).toList())

    while (queue.size > 1) {
        queue.poll()
        queue.offer(queue.poll())
    }
    println(queue.poll())
}
