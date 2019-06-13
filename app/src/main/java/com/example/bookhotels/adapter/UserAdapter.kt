package com.example.bookhotels.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bookhotels.R
import com.example.bookhotels.dto.User
import com.example.bookhotels.uiview.chatuser.ChatUserActivity
import kotlinx.android.synthetic.main.custum_user.view.*

class UserAdapter(var context: Context,var userlist:ArrayList<User>):
    RecyclerView.Adapter<UserAdapter.Adapterviewhodel>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapterviewhodel {
        val view :View = LayoutInflater.from(context).inflate(R.layout.custum_user,parent,false)

        return Adapterviewhodel(view)
    }

    override fun getItemCount(): Int {
            return userlist.size
    }

    override fun onBindViewHolder(holder: Adapterviewhodel, position: Int) {
        var  user=userlist.get(position)
        holder.tvname!!.text = user.username
        holder.imganhchat=null
        holder.setdata(user,position)
    }

    class Adapterviewhodel(itemview:View): RecyclerView.ViewHolder(itemview) {

        var user:User?=null
        var postpo:Int=0
        init {

            itemview.setOnClickListener {
                var intent: Intent = Intent(itemView.context,ChatUserActivity::class.java)
                intent.putExtra("iduser", user!!.id)
                intent.putExtra("username", user!!.username)
                itemView.context.startActivity(intent)
               // Toast.makeText(itemView.context,"id ne "+ hotelis!!._idhotels,Toast.LENGTH_LONG).show()

            }
        }
           var tvname: TextView?=itemView.tvname
        var imganhchat: ImageButton?=itemView.imganhchat

        fun setdata( use:User?,pos:Int){
            this.user=use
            this.postpo= pos
        }
    }
}