package com.project.justai.controller

import com.project.justai.model.EventModel
import com.project.justai.service.BotService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/webhook")
class WebHookController(
    private val botService: BotService
) {

    @PostMapping
    suspend fun receiveEvent(@RequestBody eventModel: EventModel) = botService.eventHandler(eventModel)
}
