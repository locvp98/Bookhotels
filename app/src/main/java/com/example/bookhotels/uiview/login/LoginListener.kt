package com.example.bookhotels.uiview.login

interface LoginListener {
    fun loginSuccess(name:String,_id:String)
    fun loginFale(message: String)
}