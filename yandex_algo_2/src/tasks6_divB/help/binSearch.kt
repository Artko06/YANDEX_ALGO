package tasks6_divB.help

fun binSearch(array: List<Int>, target: Int): Int {
    var left = 0
    var right = array.size - 1

    while (left <= right) {
        val mid = (left + right) / 2

        when{
            array[mid] == target -> return mid
            array[mid] < target -> left = mid + 1
            array[mid] > target -> right = mid - 1
        }
    }

    return -1
}

fun lBinSearch(array: List<Int>, target: Int): Int {
    var left = 0
    var right = array.size - 1

    while (left < right) {
        val mid = (left + right) / 2

        if (array[mid] < target) left = mid + 1
        else right = mid
    }

    return left
}

fun rBinSearch(array: List<Int>, target: Int): Int {
    var left = 0
    var right = array.size - 1

    while (left < right) {
        val mid = (left + right + 1) / 2

        if (array[mid] > target) right = mid - 1
        else left = mid
    }

    return left
}