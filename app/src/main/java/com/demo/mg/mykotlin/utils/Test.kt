package com.demo.mg.mykotlin.utils

import com.demo.mg.mykotlin.dao.Persen


class Test{

    /** 我是main入口函数 **/
    fun main(args: Array<String>) {
        list()
    }

    fun list(){
        val people = listOf(Persen("jack", 29),
            Persen("nick", 23),
            Persen("jone", 26))

        println(people.groupBy{it.age})
    }
}
