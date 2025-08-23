package seq_deque_heap.help

// Min heap
class MinHeap<T: Comparable<T>> {
    private val heap = mutableListOf<T>()

    fun push(value: T) {
        heap.add(value)
        siftUp(index = heap.lastIndex)
    }

    fun popMin(): T? {
        if (isEmpty()) return null
        val min = heap.first()
        heap[0] = heap.last()
        heap.removeLast()
        siftDown(0)
        return min
    }

    fun peekMin(): T? {
        if (isEmpty()) return null
        return heap.first()
    }

    fun size() = heap.size

    fun isEmpty() = heap.isEmpty()

    fun isNotEmpty() = heap.isNotEmpty()

    private fun siftUp(index: Int) {
        var index = index
        var parent = (index - 1) / 2
        while (index > 0 && heap[index] < heap[parent]) {
            swap(index, parent)
            index = parent
            parent = (index - 1) / 2
        }
    }

    private fun siftDown(index: Int) {
        var index = index
        while (true) {
            val leftChild = 2 * index + 1
            val rightChild = 2 * index + 2
            var smallest = index

            if (leftChild < heap.size && heap[leftChild] < heap[smallest]) {
                smallest = leftChild
            }
            if (rightChild < heap.size && heap[rightChild] < heap[smallest]) {
                smallest = rightChild
            }

            if (smallest == index) break
            swap(index, smallest)
            index = smallest
        }
    }

    private fun swap(index1: Int, index2: Int) {
        heap[index1] = heap[index2].also { heap[index2] = heap[index1] }
    }
}

// Max heap
class MaxHeap<T: Comparable<T>> {
    private val heap = mutableListOf<T>()

    fun push(value: T) {
        heap.add(value)
        siftUp(index = heap.lastIndex)
    }

    fun popMax(): T? {
        if (isEmpty()) return null
        val max = heap.first()
        heap[0] = heap.last()
        heap.removeLast()
        siftDown(0)
        return max
    }

    fun peekMax(): T? {
        if (isEmpty()) return null
        return heap.first()
    }

    fun size() = heap.size

    fun isEmpty() = heap.isEmpty()

    fun isNotEmpty() = heap.isNotEmpty()

    private fun siftUp(index: Int) {
        var index = index
        var parent = (index - 1) / 2
        while (index > 0 && heap[index] > heap[parent]) {
            swap(index, parent)
            index = parent
            parent = (index - 1) / 2
        }
    }

    private fun siftDown(index: Int) {
        var index = index
        while (true) {
            val leftChild = 2 * index + 1
            val rightChild = 2 * index + 2
            var smallest = index

            if (leftChild < heap.size && heap[leftChild] > heap[smallest]) {
                smallest = leftChild
            }
            if (rightChild < heap.size && heap[rightChild] > heap[smallest]) {
                smallest = rightChild
            }

            if (smallest == index) break
            swap(index, smallest)
            index = smallest
        }
    }

    private fun swap(index1: Int, index2: Int) {
        heap[index1] = heap[index2].also { heap[index2] = heap[index1] }
    }
}