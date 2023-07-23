/**
 *  [ 효율성 ]
 *  - 메모리: 18548KB
 *  - 시간 : 132ms
 */

fun main() {
    val t = readln().toInt()

    repeat(t) {
        val n = readln().toInt()
        val array = IntArray(n + 1) { if (it == 0) 1 else it }

        for (i in 3..n) {
            array[i] = array[i - 3] + array[i - 2] + array[i - 1]
        }
        println(array.last())
    }
}
