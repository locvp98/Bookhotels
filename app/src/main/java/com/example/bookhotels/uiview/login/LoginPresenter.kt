package com.example.bookhotels.uiview.login

import android.content.Context
import com.example.bookhotels.comon.Constant

class LoginPresenter(val loginView: LoginView):LoginListener {


    var loginModel=LoginModel(this)

    fun login(email:String,password:String){

        if (!email.matches(Constant.EMAIL_TYPE.toRegex())){
            loginView.emailkhongdung()
        }
        else if (password.length<6){
            loginView.passwordphai6kitu()
        }
        else {
            loginModel.PostdataLogin(email, password)

        }
    }

    override fun loginSuccess(name:String,_id: String) {
        loginView.loginSuccess(name,_id)
    }
    override fun loginFale(message: String) {
        loginView.loginfell()
    }


}