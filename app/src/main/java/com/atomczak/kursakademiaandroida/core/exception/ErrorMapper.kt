package com.atomczak.kursakademiaandroida.core.exception

interface ErrorMapper {
    fun map(throwable: Throwable): String
}