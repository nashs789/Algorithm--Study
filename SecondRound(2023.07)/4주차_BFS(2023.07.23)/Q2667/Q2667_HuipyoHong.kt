/**
 * [ 접근 순서 ]
 * 1. BFS로 미로탐색을 풀어본적이 없음
 *
 * 2. 막무가내식의 뇌피셜로 미로탐색로직을 짜봄 북, 동, 남, 서 순으로 탐색
 *
 * 3. 재귀를 호출하는것으로 보아 DFS탐색인거 같습니다. BFS로 미로탐색 어떻게 하는지 설명해주세요.
 *
 *  [ 효율성 ]
 *  - 메모리: 26212KB
 *  - 시간 : 224ms
 */

fun main() {
    val n = readln().toInt()
    val array = Array(n + 2) {
        if (it in 1..n)
            "0${readln()}0".split("").filter(String::isNotEmpty).map(String::toInt).toIntArray()
        else
            IntArray(n + 2)
    }
    val list = mutableListOf<Int>()
    var count = 0
    fun search(i: Int, j: Int, array: Array<IntArray>) {
        array[i][j] = 2
        count++

        if (array[i - 1][j] == 1) search(i - 1, j, array)
        if (array[i][j + 1] == 1) search(i, j + 1, array)
        if (array[i + 1][j] == 1) search(i + 1, j, array)
        if (array[i][j - 1] == 1) search(i, j - 1, array)
        if (array[i - 1][j] == 2 || array[i][j + 1] == 2 || array[i + 1][j] == 2 || array[i][j - 1] == 2) return
    }

    for (i in 1..n) {
        for (j in 1..n) {
            if (array[i][j] == 1) {
                count = 0

                search(i, j, array)
                list.add(count)
            }
        }
    }
    println(list.size)
    for (answer in list.sorted()) {
        println(answer)
    }
}
