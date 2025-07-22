package tasks6.taskA

fun binarySearch(list: List<Int>, target: Int): Int {
    var left = 0
    var right = list.size - 1

    while (left <= right) {
        val mid = left + (right - left) / 2

        when{
            list[mid] == target -> return mid
            list[mid] < target -> left = mid + 1
            list[mid] > target -> right = mid - 1
        }
    }

    return -1
}

fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val arr1 = readLine()!!.trim().split(" ").map { it.toInt() }
    val arr2 = readLine()!!.trim().split(" ").map { it.toInt() }

    val strBuilder = StringBuilder()
    arr2.forEach { num ->
        when(binarySearch(arr1, num)) {
            -1 -> strBuilder.append("NO\n")
            else -> strBuilder.append("YES\n")
        }
    }

    print(strBuilder)
}