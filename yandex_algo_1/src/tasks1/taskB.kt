package tasks1

fun main(){
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    val c = readLine()!!.toInt()

    if (a + b > c && a + c > b && b + c > a){
        println("YES")
    } else println("NO")
}