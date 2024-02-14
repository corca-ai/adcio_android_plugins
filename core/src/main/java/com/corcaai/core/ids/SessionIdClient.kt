package com.corcaai.core.ids

import java.util.UUID

typealias SessionID = String

interface SessionLoader {
    fun loadSessionId(): String
}

object SessionClient : SessionLoader {
    private val identifier: String = UUID.randomUUID().toString()

    override fun loadSessionId(): String = identifier
}
