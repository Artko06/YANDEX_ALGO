package tasks2

import kotlin.math.max
import kotlin.math.min

fun main(){
    var a = 30.0
    var b = 4000.0

    val size = readLine()!!.trim().toInt()
    val info: MutableList<Pair<Double, String>> = mutableListOf()

    for(i in 1..size) {
        if (i == 1) {
            val num = readLine()!!.trim().toDouble()

            info.add(Pair(num, "first"))
        } else{
            val inputInfo = readLine()!!.trim().split(" ")

            info.add(Pair(inputInfo[0].toDouble(), inputInfo[1]))
        }

    }

    for (i in 1 until size) {
        val mid = (info[i - 1].first + info[i].first) / 2.0

        when(info[i].second) {
            "further" -> {
                if (info[i - 1].first < info[i].first){
                    b = min(b, mid)
                } else {
                    a = max(a, mid)
                }
            }
            "closer" -> {
                if (info[i - 1].first < info[i].first){
                    a = max(a, mid)
                } else {
                    b = min(b, mid)
                }
            }
        }
    }

    if (a > b) {
        a = b.also { b = a }
    }

    println("%.6f %.6f".format(a, b).replace(",","."))
}