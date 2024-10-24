package io.j0a0m4

typealias Metadata = Map<String, Any>

data class ProblemDetails(
    val title: String,
    val type: String,
    val detail: String,
    val status: Int = 422,
    val metadata: Metadata = emptyMap(),
)