package com.example.bookhotels.uiview.login

interface LoginListener {
    fun loginSuccess(name:String)
    fun loginFale(message: String)
}