package edu.co.javeriana.tais2020.laurel.login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Patterns
import edu.co.javeriana.tais2020.laurel.repository.LoginRepository
import edu.co.javeriana.tais2020.laurel.login.data.Result

import edu.co.javeriana.tais2020.laurel.R
import edu.co.javeriana.tais2020.laurel.login.data.LoggedInUserView
import edu.co.javeriana.tais2020.laurel.login.data.LoginFormState
import edu.co.javeriana.tais2020.laurel.login.data.LoginResult
import kotlinx.coroutines.*

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    fun login(username: String, password: String) {
        // can be launched in a separate asynchronous job
        GlobalScope.async {
            val result = loginRepository.login(username, password)

            withContext(Dispatchers.Main) {
                if (result is Result.Success) {
                    _loginResult.value = LoginResult(success = LoggedInUserView(displayName = result.data.displayName))
                } else {
                    _loginResult.value = LoginResult(error = R.string.login_failed)
                }
            }
        }
    }

    fun hasSession(): Boolean {
        return loginRepository.hasSession()
    }

    fun loginWithSession() {
        _loginResult.value = LoginResult(success = LoggedInUserView(displayName = loginRepository.user?.displayName!!))
    }

    fun logout() {
        loginRepository.logout()
    }

    fun loginDataChanged(username: String, password: String) {
        if (!isUserNameValid(username)) {
            _loginForm.value = LoginFormState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(password)) {
            _loginForm.value = LoginFormState(passwordError = R.string.invalid_password)
        } else {
            _loginForm.value = LoginFormState(isDataValid = true)
        }
    }

    // A placeholder username validation check
    private fun isUserNameValid(username: String): Boolean {
        return if (username.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }
}