package com.project.justai.exception

open class BusinessException(
    val code: Int,
    val text: String
) : RuntimeException()
