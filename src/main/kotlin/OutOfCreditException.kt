package io.j0a0m4

import io.j0a0m4.ExceptionName.problemDetails
import java.math.BigDecimal

class OutOfCreditException(
    private val balance: BigDecimal,
    private val cost: BigDecimal,
    private val accountNums: Collection<String>,
) : ProblemType() {
    companion object {
        private const val DETAIL_MSG = "Your current balance is '%s', but that costs '%s'."
    }

    override fun toProblemDetails() = problemDetails(
        status = 403,
        detail = DETAIL_MSG.format(balance, cost),
        metadata = mapOf(
            "balance" to balance,
            "accounts" to accountNums.map { "/accounts/$it" }
        )
    )
}

