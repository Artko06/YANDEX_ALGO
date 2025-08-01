package tasks1_divB

fun main() {
    val codeReturn: Byte = readLine()!!.toByte() // [-128, 127]
    val codeInteractor: Byte = readLine()!!.toByte() // [0, 7]
    val codeChecker: Byte = readLine()!!.toByte() // [0, 7]

    if(codeInteractor == 0.toByte() && codeReturn != 0.toByte()) println(3)
    else if (codeInteractor == 0.toByte() && codeReturn == 0.toByte()) println(codeChecker)
    else if(codeInteractor == 1.toByte()) println(codeChecker)
    else if(codeInteractor == 4.toByte() && codeReturn != 0.toByte()) println(3)
    else if(codeInteractor == 4.toByte() && codeReturn == 0.toByte()) println(4)
    else if(codeInteractor == 6.toByte()) println(0)
    else if(codeInteractor == 7.toByte()) println(1)
    else println(codeInteractor)
}