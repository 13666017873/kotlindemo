package com.demo.mg.mykotlin.ui.adapter

import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.demo.mg.mykotlin.R
import com.demo.mg.mykotlin.dao.UserDao

class ReadListAdapter(private var mContext: Context, dataList: MutableList<UserDao>) : RecycleViewAdapter<UserDao>(dataList) {

    override fun getLayoutId(viewType: Int): Int {
        return R.layout.item_user
    }

    override fun convert(holder: ViewHolder, t: UserDao, position: Int) {

        val image: ImageView = holder.getView(R.id.image) as ImageView
        image.setBackgroundResource(R.drawable.ic_launcher_background)
        val idTextView: TextView = holder.getView(R.id.id) as TextView
        idTextView.setText(t.id.toString())
        val userNameTextView: TextView = holder.getView(R.id.username) as TextView
        userNameTextView.setText(t.userName!!)
        val passwordTextView: TextView = holder.getView(R.id.password) as TextView
        passwordTextView.setText(t.passWord!!)
        passwordTextView.setOnClickListener{
            Toast.makeText(mContext,  "position:" + position , Toast.LENGTH_SHORT).show()
        }
    }
}