package com.project.justai.exception.impl

import com.project.justai.exception.BusinessException

private const val CODE = 400
private const val TEXT = "Bad type event"

class BadTypeEventException : BusinessException(CODE, TEXT)
