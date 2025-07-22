package tasks1

fun systemOfEquations(a: Double, b: Double, c: Double, d: Double, e: Double, f: Double): List<String> {
    val determinant = a * d - b * c
    if (determinant == 0.0) {
        if (a == 0.0 && c == 0.0) {
            if (b == 0.0 && d == 0.0) {
                return if (e == 0.0 && f == 0.0) listOf("5") else listOf("0")
            }

            return if (e * d != f * b) {
                listOf("0")
            } else {
                if (b != 0.0) listOf("4", "%.5f".format(e / b))
                else listOf("4", "%.5f".format(f / d))
            }
        }

        if (b == 0.0 && d == 0.0) {
            return if (e * c != f * a) {
                listOf("0")
            } else {
                if (a != 0.0) listOf("3", "%.5f".format(e / a))
                else listOf("3", "%.5f".format(f / c))
            }
        }

        if (a != 0.0) {
            val coefficient = c / a
            val newD = d - coefficient * b
            val newF = f - coefficient * e
            if (newD == 0.0 && newF == 0.0) {
                return listOf("1", "%.5f".format(-a / b), "%.5f".format(e / b))
            }
        } else if (c != 0.0) {
            val coefficient = a / c
            val newB = b - coefficient * d
            val newE = e - coefficient * f
            if (newB == 0.0 && newE == 0.0) {
                return listOf("1", "%.5f".format(-c / d), "%.5f".format(f / d))
            }
        }

        return listOf("0")
    } else {
        val x: Double
        val y: Double
        if (d != 0.0) {
            x = (e - b * f / d) / (a - b * c / d)
            y = (f - c * x) / d
        } else {
            x = (f - d * e / b) / (c - d * a / b)
            y = (e - a * x) / b
        }
        return listOf("2", "%.5f".format(x), "%.5f".format(y))
    }
}


fun main() {
    val inputs = List(6) { readLine()!!.toDouble() }
    val result = systemOfEquations(inputs[0], inputs[1], inputs[2], inputs[3], inputs[4], inputs[5])
    println(result.joinToString(" "))
}
