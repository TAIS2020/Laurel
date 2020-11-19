package edu.co.javeriana.tais2020.laurel.data

import android.util.Log
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import edu.co.javeriana.tais2020.laurel.model.LoggedInUser
import kotlinx.coroutines.*
import kotlinx.coroutines.tasks.await
import java.io.IOException
import java.lang.Exception

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    var auth: FirebaseAuth = FirebaseAuth.getInstance()

    suspend fun login(username: String, password: String): Result<LoggedInUser> {
        return try {
            var authResult = auth.signInWithEmailAndPassword(username, password).await()

            authResult.user?.uid?.let {
                return Result.Success(LoggedInUser(it, username))
            }

            return Result.Error(IOException("Error logging in"))

        } catch (e: Exception) {
            Result.Error(IOException("Error logging in"))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}