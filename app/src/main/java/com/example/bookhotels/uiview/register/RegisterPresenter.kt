package com.example.bookhotels.uiview.register

import com.example.bookhotels.comon.Constant

class RegisterPresenter(val registerView: RegisterView):ResgisterListener {

    private val registerModel=RegisterModel(this)

    fun postdata(email:String,password:String,username:String){
        val emailtype = email.matches(Constant.EMAIL_TYPE.toRegex())
        if (emailtype){
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