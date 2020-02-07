package com.livewire.app.ui.login

/**
 * Data class to hold a username login error, password login error, and if the data is valid
 */
data class LoginFormState(
    val usernameError: Int? = null,
    val passwordError: Int? = null,
    val isDataValid: Boolean = false
)