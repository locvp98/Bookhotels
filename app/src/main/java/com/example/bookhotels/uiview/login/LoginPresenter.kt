package com.example.bookhotels.uiview.login

import android.content.Context

class LoginPresenter(val loginView: LoginView):LoginListener {


    var loginModel=LoginModel(this)

    fun login(email:String,password:String){
        if (email.length<2){
            loginView.loginfell()
        }
        else {
            loginModel.PostdataLogin(email, password)

        }
    }

    override fun loginSuccess(name:String) {
        loginView.loginSuccess(name)
    }
    override fun loginFale(message: String) {
        loginView.loginfell()
    }


}