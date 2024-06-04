package com.project.justai.model

import com.fasterxml.jackson.annotation.JsonProperty

data class EventModel(
    @field:JsonProperty("type") val type: String,
    @field:JsonProperty("object") val event: EventMessage?,
    @field:JsonProperty("group_id") val groupId: Long
)

data class EventMessage(
    val message: MessageModel
)
