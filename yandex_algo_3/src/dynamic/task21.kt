package dynamic

fun main() {
    val n = readln().toInt()
    val dp0 = MutableList(n + 1) {0} // ends with 0
    val dp1 = MutableList(n + 1) {0} // ends with 1
    val dp2 = MutableList(n + 1) {0} // ends with 11

    dp0[1] = 1
    dp1[1] = 1
    dp2[1] = 0

    for (i in 2..n) {
        dp0[i] = dp0[i - 1] + dp1[i - 1] + dp2[i - 1]
        dp1[i] = dp0[i - 1]
        dp2[i] = dp1[i - 1]
    }

    println(dp0[n] + dp1[n] + dp2[n])
}