/**
 *  [ 효율성 ]
 *  - 메모리: 20748KB
 *  - 시간 : 132ms
 */

fun main() {
    var (a, b) = readln().split(" ").map(String::toInt)
    var answer = 1

    while (a != b) {
        answer++
        when {
            b % 10 == 1 -> b /= 10
            b % 2 == 0 -> b /= 2
            else -> {
                answer = -1
                break
            }
        }
        if (a > b) {
            answer = -1
            break
        }
    }
    println(answer)
}
