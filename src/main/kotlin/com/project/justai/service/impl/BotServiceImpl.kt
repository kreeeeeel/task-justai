package com.project.justai.service.impl

import com.project.justai.exception.impl.BadGroupException
import com.project.justai.exception.impl.BadTypeEventException
import com.project.justai.model.EventModel
import com.project.justai.property.BotProperty
import com.project.justai.retrofit.VkMessageApi
import com.project.justai.service.BotService
import org.springframework.stereotype.Service

private const val CONFIRMATION_EVENT = "confirmation"
private const val MESSAGE_NEW_EVENT = "message_new"

@Service
class BotServiceImpl(
    private val botProperty: BotProperty,
    private val vkMessageApi: VkMessageApi
) : BotService {

    override suspend fun eventHandler(eventModel: EventModel): String = when (eventModel.type) {
        CONFIRMATION_EVENT -> getConfirmationCode(eventModel.groupId)
        MESSAGE_NEW_EVENT -> sendMessage(eventModel)
        else -> throw BadTypeEventException()
    }

    private suspend fun getConfirmationCode(groupId: Long): String {
        if (groupId != botProperty.groupId) {
            throw BadGroupException()
        }
        return botProperty.confirmationCode
    }

    private suspend fun sendMessage(eventModel: EventModel): String {
        eventModel.event?.let {
            vkMessageApi.sendMessage(
                message = "Вы сказали: ${it.message.text}",
                userId = it.message.fromId,
                randomId = it.message.messageId
            )
        }
        return "ok"
    }
}
