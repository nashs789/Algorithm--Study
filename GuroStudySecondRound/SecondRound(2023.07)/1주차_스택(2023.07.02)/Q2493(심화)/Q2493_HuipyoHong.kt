/**
 * [ 접근 순서 ]
 * 1. 높은 값을 탐색할때 순차적으로 탐색하면 시간초과 나므로 배열을 이용
 *
 * 2. 배열을 이용한 메모이제이션 기법으로 탐색 -> 성공
 *
 * 3. 10번만에 시도해서 성공
 *
 *  [ 효율성 ]
 *  - 메모리: 135388KB
 *  - 시간 : 824ms
 */

fun main() {
    val n = readln().toInt()
    val list = readln().split(" ")
    val array = IntArray(n)

    for (i in 1 until n) {
        array[i] = findHighNumber(i, list, array)
    }
    println(array.joinToString(" "))
}

private fun findHighNumber(index: Int, list: List<String>, array: IntArray): Int {
    var position = index - 1

    while (position >= 0 && list[index].toInt() > list[position].toInt()) {
        position = array[position] - 1
    }
    return position + 1
}
