package com.project.justai.property

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "bot")
class BotProperty {
    lateinit var apiVk: String
    lateinit var versionApi: String
    lateinit var accessToken: String
    lateinit var confirmationCode: String
    var groupId: Long = 0L
}
