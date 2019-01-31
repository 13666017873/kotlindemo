package com.demo.mg.mykotlin.ui

import android.annotation.SuppressLint
import com.demo.mg.mykotlin.R
import com.demo.mg.mykotlin.dao.UserDao
import com.demo.mg.mykotlin.ui.adapter.ReadListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    //TestTestTestTestTestTestTestTestTest

    override fun initLayout(): Int { return R.layout.activity_main
    }

    override fun initView() {

    }

    @SuppressLint("SetTextI18n")
    override fun initData() {

        val tbList: MutableList<UserDao> = ArrayList()

            for(id in 0..10){
                val userDao = UserDao(id, "","", "")
                userDao.id = id
                userDao.nikeName = ("nikeName"+ id)
                userDao.passWord = ("passWord"+ id)
                userDao.userName = ("userName"+ id)
                tbList.add(userDao)
        }
        recyclerview.setAdapter(ReadListAdapter(this,tbList))
    }
}
