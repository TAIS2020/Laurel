package edu.co.javeriana.tais2020.laurel.repository

import edu.co.javeriana.tais2020.laurel.login.data.LoginDataSource
import edu.co.javeriana.tais2020.laurel.login.data.Result
import edu.co.javeriana.tais2020.laurel.login.model.LoggedInUser

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */

class LoginRepository(val dataSource: LoginDataSource) {

    // in-memory cache of the loggedInUser object
    var user: LoggedInUser? = null
        private set

    val isLoggedIn: Boolean
        get() = user != null

    init {
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
        user = null
    }

    fun logout() {
        user = null
        dataSource.logout()
    }

    suspend fun login(username: String, password: String): Result<LoggedInUser> {
        val result = dataSource.login(username, password)

        if (result is Result.Success) {
            setLoggedInUser(result.data)
        }

        return result
    }

    fun hasSession(): Boolean {
        if (dataSource.auth != null) {

            dataSource.auth.currentUser?.let {
                setLoggedInUser(LoggedInUser(it.uid, it.displayName!!))
                return true
            }

            return false
        }

        return false
    }

    private fun setLoggedInUser(loggedInUser: LoggedInUser) {
        this.user = loggedInUser
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }
}