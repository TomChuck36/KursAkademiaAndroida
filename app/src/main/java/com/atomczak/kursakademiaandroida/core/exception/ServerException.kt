package com.atomczak.kursakademiaandroida.core.exception

sealed class ServerException(message: String?) : Throwable(message) {
    class Internal(message: String?) : Throwable(message)
    class BadRequest(message: String?) : Throwable(message)
    class Unknown(message: String?) : Throwable(message)
}