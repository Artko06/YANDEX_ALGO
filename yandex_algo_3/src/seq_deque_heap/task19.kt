package seq_deque_heap

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

    fun isEmpty() = heap.isEmpty()

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

fun main() {
    val heap = MaxHeap<Int>()
    val n = readln().toInt()

    val writer = System.out.bufferedWriter()
    repeat(n) {
        val line = readln().split(" ")

        when (line[0]) {
            "0" -> {
                heap.push(line[1].toInt())
            }

            "1" -> {
                writer.write("${heap.popMax()!!}\n")
            }
        }
    }
    writer.flush()
}