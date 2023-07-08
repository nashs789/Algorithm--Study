/**
 *  [ 효율성 ]
 *  - 메모리: 173704KB
 *  - 시간 : 1464ms
 */

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val sb = StringBuilder()

    repeat(n) {
        val operators: Queue<Char> = LinkedList(br.readLine().toList())
        val number = br.readLine()
        val deque: Deque<Int> = LinkedList(
            br.readLine()
                .replace("[", "")
                .replace("]", "")
                .split(",".toRegex())
                .filter(String::isNotEmpty)
                .map(String::toInt)
        )
        var isReversed = false

        if (operators.count { it == 'D' } > deque.size) {
            sb.append("error").append("\n")
            return@repeat
        } else {
            while (operators.isNotEmpty()) {
                when (operators.poll()) {
                    'R' -> isReversed = !isReversed
                    'D' -> if (isReversed) deque.pollLast() else deque.pollFirst()
                }
            }
        }
        sb.append("${if (isReversed) deque.reversed() else deque}".replace(" ", "")).append("\n")
    }
    br.close()
    bw.write(sb.toString())
    bw.close()
}
