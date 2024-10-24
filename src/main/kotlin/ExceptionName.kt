package io.j0a0m4

object ExceptionName {
    private val String.asKebabCase
        get() = split(" ")
            .joinToString("-")
            .lowercase()

    private val String.className
        get() = split(".").last()

    private val String.exceptionName
        get() = dropLast(9)

    private val String.asTitleCase
        get() = replace(Regex("([A-Z])"), " $1")
            .trim()

    private val <T> Class<T>.problemName
        get() = simpleName
            .className
            .exceptionName

    val <T> Class<T>.problemTitle
        get() = problemName.asTitleCase

    val <T> Class<T>.problemType
        get() = problemTitle.asKebabCase

    fun Exception.problemDetails(
        detail: String,
        metadata: Metadata,
        status: Int = 422
    ) = ProblemDetails(
        title = javaClass.problemTitle,
        type = "transactions/errors/${javaClass.problemType}",
        status = status,
        detail = detail,
        metadata = metadata
    )
}