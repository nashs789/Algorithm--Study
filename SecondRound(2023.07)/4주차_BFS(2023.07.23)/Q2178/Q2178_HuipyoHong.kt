/**
 * [ 접근 순서 ]
 * 1. BFS로 도착지점이 있는 곳의 level(또는 depth)만 구하면 되는 문제
 *
 *  [ 효율성 ]
 *  - 메모리: 24744KB
 *  - 시간 : 224ms
 */

import java.util.*

fun main() {
    val (n, m) = readln().split(" ").map(String::toInt)
    val array = (0..n + 1).map { if ((1..n).contains(it)) "0${readln()}0".map(Char::digitToInt).toIntArray() else IntArray(m + 2) }
    val bfs = fun(start: IntArray): Int {
        val queue = LinkedList(listOf(start))

        while (queue.isNotEmpty()) {
            val (i, j, l) = queue.poll()
            array[i][j] = 2

            if (i == n && j == m) return l
            for ((nextI, nextJ) in arrayOf(intArrayOf(i - 1, j), intArrayOf(i, j + 1), intArrayOf(i + 1, j), intArrayOf(i, j - 1))) {
                if (array[nextI][nextJ] == 1) {
                    array[nextI][nextJ] = 2

                    queue.offer(intArrayOf(nextI, nextJ, l + 1))
                }
            }
        }
        return 0
    }

    println(bfs(intArrayOf(1, 1, 1)))
}
