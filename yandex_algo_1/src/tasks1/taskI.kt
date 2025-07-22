package tasks1

fun main(){
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    val c = readLine()!!.toInt()
    val d = readLine()!!.toInt()
    val e = readLine()!!.toInt()

    if (a <= d && b <= e) print("YES")
    else if (b <= d && a <= e) print("YES")
    else if (b <= e && c <= d) print("YES")
    else if (c <= e && b <= d) print("YES")
    else if (a <= e && c <= d) print("YES")
    else if (c <= e && a <= d) print("YES")
    else print("NO")
}