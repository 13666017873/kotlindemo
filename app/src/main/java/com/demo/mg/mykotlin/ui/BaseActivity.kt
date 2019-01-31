package com.demo.mg.mykotlin.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.FragmentActivity

@SuppressLint("Registered")
abstract class BaseActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(initLayout())
        initData()
        initView()
    }

    abstract fun initLayout(): Int
    abstract fun initView()
    abstract fun initData()
}