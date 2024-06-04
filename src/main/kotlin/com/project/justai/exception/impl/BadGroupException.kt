package com.project.justai.exception.impl

import com.project.justai.exception.BusinessException

private const val CODE = 400
private const val TEXT = "Bad group id"

class BadGroupException : BusinessException(CODE, TEXT)
