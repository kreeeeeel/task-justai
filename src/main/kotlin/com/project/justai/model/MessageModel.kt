package com.project.justai.model

import com.fasterxml.jackson.annotation.JsonProperty

data class MessageModel(
    @field:JsonProperty("text") val text: String,
    @field:JsonProperty("from_id") var fromId: Long
)
