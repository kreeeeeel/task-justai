package com.project.justai.service

import com.project.justai.model.EventModel

interface BotService {
    suspend fun eventHandler(eventModel: EventModel): String
}
