package info

fun binarySearch(arr: List<Int>, target: Int): Int {
    var left = 0
    var right = arr.size - 1

    while (left <= right) {
        val mid = (left + right) / 2

        when{
            arr[mid] == target -> return mid
            arr[mid] < target -> left = mid + 1
            arr[mid] > target -> right = mid - 1
        }
    }

    return -1
}


//                     /---------------------------------
// -------------------/

fun lBinSearch(arr: List<Int>, target: Int): Int {
    var left = 0
    var right = arr.size - 1

    while (left < right) {
        val mid = (left + right) / 2

        if (arr[mid] < target) { // bad
            left = mid + 1
        } else right = mid
    }

    return left
}


// ------------------------/
//                         /---------------------------------

fun rBinSearch(arr: List<Int>, target: Int): Int {
    var left = 0
    var right = arr.size - 1

    while (left < right) {
        val mid = (left + right + 1) / 2

        if (arr[mid] > target) {
            right = mid - 1
        } else left = mid
    }

    return left
}