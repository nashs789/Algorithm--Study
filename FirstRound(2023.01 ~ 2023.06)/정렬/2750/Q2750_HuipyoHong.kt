/**
 *  [ 효율성 ]
 *  - 메모리: 19452KB
 *  - 시간 : 228ms
 */

package BaekJoon.Sorting.Q2750

fun main() {
    Array(readln().toInt()) { readln().toInt() }.toSortedSet().forEach(::println)
}
