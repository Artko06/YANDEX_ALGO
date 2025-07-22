package tasks7

const val ENTRY_POST: Byte = 1
const val EXIT_POST: Byte = 2

const val MIN_TIME = 0
const val MAX_TIME = 10000

fun main() {
    val k = readLine()!!.toInt()
    val strOutput = StringBuilder()
    for (i in 0 until k) {
        val input = readLine()!!.split(" ").map { it.toInt() }

        val n = input[0]
        val infoPost = mutableListOf<Triple<Int, Byte, Int>>()
        for (i in 1 .. 2 * n step 2) {
            infoPost.add(Triple(input[i], ENTRY_POST, i))
            infoPost.add(Triple(input[i + 1], EXIT_POST, i))
        }
        infoPost.sortWith( compareBy({ it.first }, { it.second }))

        if (infoPost[0].first != MIN_TIME || infoPost.last().first != MAX_TIME) {
            strOutput.append("Wrong Answer\n")
            continue
        }

        val uniqueSetSecurity = mutableSetOf<Int>()
        val tempSetSecurity = mutableSetOf<Int>()
        var lastTime = -1
        for((time, typeEvent, uniqueNum) in infoPost) {
            if (tempSetSecurity.isEmpty() && time != 0) { // no security
                uniqueSetSecurity.clear()
                break
            }

            if (tempSetSecurity.size == 1 && time != lastTime) {
                uniqueSetSecurity.addAll(tempSetSecurity)
            }

            if (typeEvent == ENTRY_POST) {
                tempSetSecurity.add(uniqueNum)
            } else if (typeEvent == EXIT_POST) {
                tempSetSecurity.remove(uniqueNum)
            }

            lastTime = time
        }

        if (uniqueSetSecurity.size == n) {
            strOutput.append("Accepted\n")
        } else strOutput.append("Wrong Answer\n")
    }

    print(strOutput)
}