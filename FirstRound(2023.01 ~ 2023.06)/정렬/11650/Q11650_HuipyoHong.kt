/**
 *  [ 효율성 ]
 *  - 메모리: 112896KB
 *  - 시간 : 2512ms
 */

package BaekJoon.Sorting.Q11650

fun main() {
    Array(readln().toInt()) { readln().split(" ").map(String::toInt) }
        .sortedWith { (f1, l1), (f2, l2) ->
            if (f1 == f2) l1.compareTo(l2) else f1.compareTo(f2)
        }
        .forEach { println(it.joinToString(" ")) }
}
