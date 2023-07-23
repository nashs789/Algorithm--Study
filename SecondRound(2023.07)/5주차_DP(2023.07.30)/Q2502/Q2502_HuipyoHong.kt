/**
 *  [ 효율성 ]
 *  - 메모리: 20656KB
 *  - 시간 : 132ms
 */

fun main() {
    val (d, k) = readln().split(" ").map(String::toInt)
    val dp = IntArray(d)
    dp[0] = k

    loop@ for (a in 1 until k / 2) {
        dp[1] = k / 2 + a

        for (i in 2 until dp.size) {
            dp[i] = dp[i - 2] - dp[i - 1]

            if (dp[i - 1] < dp[i]) continue@loop
        }
        println(dp[dp.size - 1])
        println(dp[dp.size - 2])
        return
    }
}
