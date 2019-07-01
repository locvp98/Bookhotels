package com.example.bookhotels.uiview.register

import com.example.bookhotels.comon.Constant

class RegisterPresenter(val registerView: RegisterView):ResgisterListener {

    private val registerModel=RegisterModel(this)

    fun postdata(email:String,password:String,username:String){

        if (!email.matches(Constant.EMAIL_TYPE.toRegex())){
            registerView.emailkhongdung()
        }
        else if (password.length<6){
            registerView.passwordphai6kitu()
        }
        else {
                registerModel.posdataregister(email,password,username)
        }


    }

    override fun loginSuccess() {
        registerView.loginSuccess()
    }

    override fun loginFale(message: String) {
        registerView.loginFale(message)
    }

}