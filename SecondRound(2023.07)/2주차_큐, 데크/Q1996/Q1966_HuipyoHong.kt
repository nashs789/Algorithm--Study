/**
 *  [ 효율성 ]
 *  - 메모리: 21356KB
 *  - 시간 : 188ms
 */

import java.util.*

data class HuiPyoPrinter(val priority: Int, val index: Int)

fun main() {
    val count = readln().toInt()

    repeat(count) {
        val (n, m) = readln().split(" ").map(String::toInt)
        val priorities = readln().split(" ").map(String::toInt).toIntArray()
        var answer = 0
        var isTrue = false
        val queue = LinkedList<HuiPyoPrinter>()

        for (j in 0 until n) {
            queue.add(HuiPyoPrinter(priorities[j], j))
        }
        priorities.sort()
        for (k in n - 1 downTo 0) {
            while (true) {
                if (priorities[k] == queue.peek().priority) {
                    if (queue.peek().index == m)
                        isTrue = true
                    queue.poll()
                    break
                } else {
                    queue.add(queue.poll())
                }
            }
            answer++
            if (isTrue) {
                break
            }
        }
        println(answer)
    }
}
