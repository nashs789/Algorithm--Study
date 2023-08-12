/**
 *  [ 효율성 ]
 *  - 메모리: 23936KB
 *  - 시간 : 172ms
 */

fun main() {
    val (_, l) = readln().split(" ").map(String::toInt)
    val list = readln().split(" ").map(String::toInt).sorted()
    var answer = 0
    var start = 0

    while (start < list.size) {
        val next = list.indexOfFirst { it > list[start] + l - 1 }
        answer++
        if (next > -1) start = next
        else break
    }
    println(answer)
}
