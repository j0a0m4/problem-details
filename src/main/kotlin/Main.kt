package io.j0a0m4

fun main() {
    val problem = OutOfCreditException(
        balance = 30.toBigDecimal(),
        cost = 50.toBigDecimal(),
        accountNums = listOf("12345", "67890")
    )
    // 1 - Exception Message
    println(problem)
    // 2 - Problem Details content
    println(problem.toProblemDetails())
}


