package com.demo.mg.mykotlin.ui

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import com.demo.mg.mykotlin.R
import com.demo.mg.mykotlin.dao.UserDao
import com.demo.mg.mykotlin.http.ApiClient
import com.demo.mg.mykotlin.http.ApiErrorModel
import com.demo.mg.mykotlin.http.ApiResponse
import com.demo.mg.mykotlin.http.NetworkScheduler
import com.demo.mg.mykotlin.ui.adapter.ReadListAdapter
import com.demo.mg.mykotlin.utils.Repo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun initLayout(): Int { return R.layout.activity_main
    }

    @SuppressLint("LogNotTimber")
    override fun initView() {

        ApiClient.instance.service.listRepos("13666017873")
            .compose(NetworkScheduler.compose())
            .subscribe(object : ApiResponse<List<Repo>>(this) {
                override fun success(data: List<Repo>) {
                    Log.e("dfdf", data[0].owner.login)
                    Log.e("dfdf", data[0].owner.url)
                }

                override fun failure(statusCode: Int, apiErrorModel: ApiErrorModel) {
                    Toast.makeText(this@MainActivity, apiErrorModel.message, Toast.LENGTH_SHORT).show()
                }
            })
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
