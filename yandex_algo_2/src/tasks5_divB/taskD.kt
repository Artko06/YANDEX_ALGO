package tasks5_divB

fun main() {
    val bracketLine = readLine()!!

    var countOpen = 0
    var countClose = 0
    for (char in bracketLine) {
        if (char == '(') countOpen++
        else if (char == ')') countClose++

        if (countClose > countOpen) break
    }

    if (countOpen == countClose) println("YES")
    else println("NO")
}