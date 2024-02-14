package com.corcaai.core.ids

import java.util.UUID

object SessionClient {
    private val identifier: String by lazy { UUID.randomUUID().toString() }

    fun loadSessionId(): String = identifier
}
