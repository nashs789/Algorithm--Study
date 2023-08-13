/**
 *  [ 효율성 ]
 *  - 메모리: 23732KB
 *  - 시간 : 148ms
 */

import kotlin.math.pow

fun main() {
    val n = readln().toInt()
    val list = List(n) { readln() }
    val mutableMap = mutableMapOf<Char, Int>()
    var number = 9

    for (word in list) {
        for (i in word.indices) {
            mutableMap[word[i]] = (mutableMap.getOrDefault(word[i], 0) + 10.0.pow(word.length - 1 - i.toDouble())).toInt()
        }
    }
    mutableMap.entries
            .sortedByDescending { it.value }
            .fold(0) { acc, e ->
                acc + number * e.value.also { number-- }
            }
            .also(::println)
}
