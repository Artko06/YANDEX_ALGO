package tasks3

import kotlin.math.max
import kotlin.math.min

data class Rectangle(
    val minXPlusY: Int,
    val minXMinusY: Int,
    val maxXPlusY: Int,
    val maxXMinusY: Int
)

fun Rectangle.extendRectangle(a: Int): Rectangle{
    return Rectangle(
        minXPlusY = this.minXPlusY - a,
        minXMinusY = this.minXMinusY - a,
        maxXPlusY = this.maxXPlusY + a,
        maxXMinusY = this.maxXMinusY + a
    )
}

fun Rectangle.intersect(navRectangle: Rectangle): Rectangle{
    return Rectangle(
        minXPlusY = max(this.minXPlusY, navRectangle.minXPlusY),
        minXMinusY = max(this.minXMinusY, navRectangle.minXMinusY),
        maxXPlusY = min(this.maxXPlusY, navRectangle.maxXPlusY),
        maxXMinusY = min(this.maxXMinusY, navRectangle.maxXMinusY)
    )
}

fun main(){
    val (t, d, n) = readLine()!!.split(" ").map { it.toInt() }

    var posRectangle = Rectangle(0,0,0,0)

    repeat(n){
        val (x, y) = readLine()!!.split(" ").map { it.toInt() }
        posRectangle = posRectangle.extendRectangle(t)
        val navRectangle = Rectangle(x + y, x - y, x + y, x - y)
            .extendRectangle(d)

        posRectangle = posRectangle.intersect(navRectangle)
    }


    val points: MutableSet<Pair<Int, Int>> = mutableSetOf()
    for (xPlusY in posRectangle.minXPlusY..posRectangle.maxXPlusY){
        for (xMinusY in posRectangle.minXMinusY..posRectangle.maxXMinusY){
            if ((xPlusY + xMinusY) % 2 == 0){
                val x = (xPlusY + xMinusY) / 2
                val y = xPlusY - x

                points.add(Pair(x, y))
            }
        }
    }

    println(points.size)
    points.forEach{ println("${it.first} ${it.second}") }
}