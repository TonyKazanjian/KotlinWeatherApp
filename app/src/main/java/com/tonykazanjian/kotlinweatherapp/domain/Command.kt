package com.tonykazanjian.kotlinweatherapp.domain

/**
 * @author Tony Kazanjian
 */
interface Command<out T> {

    fun execute(): T
}