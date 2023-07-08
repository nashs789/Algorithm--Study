/**
 *  [ 효율성 ]
 *  - 메모리: 21480KB
 *  - 시간 : 152ms
 */

import java.util.*

fun main() {
    val n = readln().split(" ")[0].toInt()
    val queue: Queue<Int> = LinkedList(readln().split(" ").map(String::toInt))
    val deque: Deque<Int> = LinkedList((1..n).toList())
    var count = 0

    while (!queue.isEmpty()) {
        val target = queue.poll()
        val start = ArrayList(deque).indexOf(target)
        val end = deque.size - start

        while (!deque.isEmpty() && target != deque.peekFirst()) {
            count++
            if (start < end) {
                deque.offerLast(deque.pollFirst())
            } else {
                deque.offerFirst(deque.pollLast())
            }
        }
        deque.pollFirst()
    }
    println(count)
}
