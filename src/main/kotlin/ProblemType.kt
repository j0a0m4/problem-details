package io.j0a0m4


abstract class ProblemType : Exception(), Detailable {

    override val message: String
        get() = toProblemDetails().asExceptionMessage

    companion object {
        private const val EXCEPTION_MSG = "An '%s' error has occurred because '%s'"

        private val ProblemDetails.asExceptionMessage
            get() = EXCEPTION_MSG.format(title, detail)
    }

}

