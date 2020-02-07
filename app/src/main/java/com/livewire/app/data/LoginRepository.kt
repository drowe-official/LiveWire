package com.livewire.app.data

import com.livewire.app.data.model.LoggedInUser

/**
 * Class constructed from a login data source, such as a login function, from a LoginDataSource object
 */

class LoginRepository(val dataSource: LoginDataSource) {

    // in-memory cache of the loggedInUser object
    var user: LoggedInUser? = null // A variable can be null if it has ? at the end of the variable name
        private set // sets the setter as private

    val isLoggedIn: Boolean
        get() = user != null // a custom getter function for isLoggedIn.

    init { // init is basically like __init__ in python.

        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
        user = null
    }

    fun logout() { // logout function. it sets the LoginRepository user as null and then runs the logout function from LoginDataSource
        user = null
        dataSource.logout()
    }

    fun login(username: String, password: String): Result<LoggedInUser> { // angle brackets <> are used to specify a type parameters. So in this case, the return value (Result),
                                                                          // must have a type parameter set as LoggedInUser

        // handle login
        val result = dataSource.login(username, password)

        if (result is Result.Success) {
            setLoggedInUser(result.data)
        }

        return result
    }

    private fun setLoggedInUser(loggedInUser: LoggedInUser) {
        this.user = loggedInUser
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }
}
