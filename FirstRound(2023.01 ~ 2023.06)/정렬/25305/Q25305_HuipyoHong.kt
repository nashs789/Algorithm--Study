/**
 *  [ 효율성 ]
 *  - 메모리: 25092KB
 *  - 시간 : 180ms
 */

package BaekJoon.Sorting.Q25305

fun main() {
    val (total, index) = readln().split(" ").map(String::toInt)

    println(readln().split(" ").map(String::toInt).sorted()[total - index])
}
