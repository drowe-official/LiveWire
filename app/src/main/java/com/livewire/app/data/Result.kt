package com.livewire.app.data

/**
 * A generic class that holds a value with its loading status.
 * EXPLANATION: Sealed classes are used for representing restricted class hierarchies, when a value can have one of the types from a limited set, but cannot have any other type
 */

sealed class Result<out T : Any> {

    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}
