package seq_deque_heap.help

fun heapSort(arr: IntArray) {
    val n = arr.size

    for (i in n / 2 - 1 downTo 0) {
        heapify(arr, n, i)
    }

    for (i in n - 1 downTo 1) {
        arr[0] = arr[i].also { arr[i] = arr[0] }
        heapify(arr, i, 0)
    }
}

// SiftDown
fun heapify(arr: IntArray, size: Int, i: Int) {
    var index = i
    while (true) {
        var largest = index
        val leftChild = 2 * index + 1
        val rightChild = 2 * index + 2

        if (leftChild < size && arr[leftChild] > arr[largest]) largest = leftChild
        if (rightChild < size && arr[rightChild] > arr[largest]) largest = rightChild

        if (largest == index) break
        arr[index] = arr[largest].also { arr[largest] = arr[index] }
        index = largest
    }
}