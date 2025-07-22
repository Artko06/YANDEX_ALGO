package tasks4

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.sequences.forEach

fun main() {
    val bankWallets = mutableMapOf<String, Long>()

    val reader = BufferedReader(InputStreamReader(System.`in`))

    reader.lineSequence().forEach { line ->
        val input = line.split(" ")

        when (input[0]) {
            "DEPOSIT" -> {
                bankWallets[input[1]] = bankWallets.getOrDefault(input[1], 0) + input[2].toLong()
            }
            "WITHDRAW" -> {
                bankWallets[input[1]] = bankWallets.getOrDefault(input[1], 0) - input[2].toLong()
            }
            "BALANCE" -> {
                val balance = bankWallets.get(input[1])

                if (balance == null) {
                    println("ERROR")
                } else println(balance)
            }
            "TRANSFER" -> {
                val balance1 = bankWallets.getOrPut(input[1]) { 0L }
                val balance2 = bankWallets.getOrPut(input[2]) { 0L }

                bankWallets[input[1]] = balance1 - input[3].toLong()
                bankWallets[input[2]] = balance2 + input[3].toLong()
            }
            "INCOME" -> {
                bankWallets.forEach { (name, balance) ->
                    if (balance > 0) {
                        bankWallets[name] = balance + (balance * input[1].toLong()) / 100
                    }
                }
            }
        }
    }
}