package tasks1

fun main() {
    var (n, k, m) = readLine()!!.split(" ").map { it.toInt() }
    var countDetails = 0

    if (m > k){
        print(countDetails)
        return
    }

    while (n >= k) {
        val countK = n / k
        n = n % k

        countDetails += (k / m) * countK
        n += (k % m) * countK
    }

    print(countDetails)
}