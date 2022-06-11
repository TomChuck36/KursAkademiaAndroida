package com.atomczak.kursakademiaandroida.core.exception

interface ErrorWrapper {
    fun wrap(throwable: Throwable): Throwable
}