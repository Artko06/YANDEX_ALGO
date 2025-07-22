package tasks4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val mapCustomers = sortedMapOf<String, MutableMap<String, Long>>()

    reader.lineSequence().forEach {
        val (customerName, product, amountStr) = it.split(" ")
        val amount = amountStr.toLong()

        val products = mapCustomers.getOrPut(customerName) { sortedMapOf() }
        products[product] = products.getOrDefault(product, 0L) + amount
    }

    val output = buildString {
        for ((customer, products) in mapCustomers) {
            appendLine("$customer:")
            for ((product, amount) in products) {
                appendLine("$product $amount")
            }
        }
    }
    print(output)
}
