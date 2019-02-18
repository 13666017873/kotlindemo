package com.demo.mg.mykotlin.utils

data class ResponseWrapper<T>(var code: Int, var data: T, var message: String)
