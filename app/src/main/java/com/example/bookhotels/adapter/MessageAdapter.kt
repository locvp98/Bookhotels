package com.example.bookhotels.adapter

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bookhotels.R
import com.example.bookhotels.dto.Messagesuser
import kotlinx.android.synthetic.main.message_left.view.*

class MessageAdapter(var context: Context, var mes:ArrayList<Messagesuser>):
    RecyclerView.Adapter<MessageAdapter.MessageViewHodel>() {

    val ITEM_TYPE_LEFT = 0
    val ITEM_TYPE_RIGHT = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHodel {
        return if (viewType == ITEM_TYPE_RIGHT) {
            val view: View = LayoutInflater.from(context).inflate(R.layout.message_right, parent, false)

           return MessageViewHodel(view)

        } else {
            val view: View = LayoutInflater.from(context).inflate(R.layout.message_left, parent, false)
            return MessageViewHodel(view)
        }
    }

    override fun getItemCount(): Int {
      return mes.size
    }

    override fun onBindViewHolder(holder: MessageViewHodel, position: Int) {
            var message =mes.get(position)
        holder.tvtenks!!.text=message.message

    }

    class MessageViewHodel(itemview:View): RecyclerView.ViewHolder(itemview) {
        var tvtenks: TextView?=itemView.tv_showmessage

    }

    override fun getItemViewType(position: Int): Int {
        var she: SharedPreferences =context.getSharedPreferences("dangnhap", Context.MODE_PRIVATE)
        var  tokens =she.getString("_id","")

        if (mes!![position].sender!!.equals(tokens)){
            return  ITEM_TYPE_RIGHT
        }else{
            return   ITEM_TYPE_LEFT
        }
    }
}