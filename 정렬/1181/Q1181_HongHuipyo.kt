/**
 *  [ 효율성 ]
 *  - 메모리: 36184KB
 *  - 시간 : 1084ms
 */

package BaekJoon.String.Q1181

fun main() {
    Array(readln().toInt()) { readln() }
        .toSortedSet { o1, o2 ->
            if (o1.length == o2.length) o1.compareTo(o2) else o1.length - o2.length
        }
        .forEach(::println)
}