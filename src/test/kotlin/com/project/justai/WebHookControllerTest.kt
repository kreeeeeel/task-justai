package com.project.justai

import com.project.justai.model.EventMessage
import com.project.justai.model.EventModel
import com.project.justai.model.MessageModel
import com.project.justai.property.BotProperty
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WebHookControllerTest (
    @Autowired val restTemplate: TestRestTemplate,
    @Autowired val botProperty: BotProperty
) {

    @LocalServerPort
    private var port: Int = 0

    @Test
    fun `request with a bad parameter groupId`() {
        val eventModel = EventModel(
            type = "confirmation",
            event = null,
            groupId = 123456
        )

        val response = request(eventModel)
        assertEquals(HttpStatus.BAD_REQUEST, response.statusCode)
    }

    @Test
    fun `request for get confirmation code`() {
        val eventModel = EventModel(
            type = "confirmation",
            event = null,
            groupId = botProperty.groupId
        )

        val response = request(eventModel)
        assertEquals(HttpStatus.OK, response.statusCode)
        assertEquals(response.body, botProperty.confirmationCode)
    }

    @Test
    fun `return ok for new message`() {
        val messageModel = MessageModel(
            text = "Привет",
            fromId = 12345,
            messageId = 1
        )

        val eventMessage = EventMessage(
            message = messageModel
        )

        val eventModel = EventModel(
            type = "message_new",
            event = eventMessage,
            groupId = 123456
        )

        val response = request(eventModel)

        assertEquals(HttpStatus.OK, response.statusCode)
        assertEquals("ok", response.body)
    }

    private fun request(eventModel: EventModel): ResponseEntity<String> {
        val headers = HttpHeaders()
        headers.set("Content-Type", "application/json")
        val request: HttpEntity<EventModel> = HttpEntity(eventModel, headers)

        return restTemplate.exchange(
            "http://localhost:$port/webhook",
            HttpMethod.POST,
            request,
            String::class.java
        )
    }
}