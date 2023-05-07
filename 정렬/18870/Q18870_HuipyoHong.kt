/**
 *  [ 효율성 ]
 *  - 메모리: 464224KB
 *  - 시간 : 3320ms
 */

package BaekJoon.Sorting.Q18870

fun main() {
    val n = readln()
    val input = readln().split(" ").map(String::toInt)
    val sortedSet = input.toSortedSet()
    val dictionary = sortedSet.zip(sortedSet.indices).toMap()

    println(input.map { dictionary[it] }.joinToString(" "))
}
