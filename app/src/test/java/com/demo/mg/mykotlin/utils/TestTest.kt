package com.demo.mg.mykotlin.utils

import com.demo.mg.mykotlin.dao.Persen
import org.junit.Test

import org.junit.Assert.*

class TestTest {

    @Test
    fun main() {
        list()
    }

    @Test
    fun list() {
        val people = listOf(
            Persen("jack", 29),
            Persen("nick", 23),
            Persen("jone", 26),
            Persen("henry", 22),
            Persen("ff", 18)
        )

        val isAge23 = { p: Persen -> p.age!! <= 23 }

        //集合所有值于条件对比返回布尔值
        println(people.all(isAge23))
        //集合中符合条件的个数
        println(people.count(isAge23))
        //查找对应
        println(people.find(isAge23))
        //集合第一个
        println(people.first())
        //集合最后一个
        println(people.last())
        //集合大小
        println(people.size)
        //直接获取集合第一个值
        println(people.component1())
        //直接获取集合第二个值
        println(people.component2())
        //直接获取集合第三个值
        println(people.component3())
        //直接获取集合第四个值
        println(people.component4())
        //直接获取集合第五个值
        println(people.component5())
        //查询集合中对应下标的值
        println(people.elementAt(1))

        val per = Persen("mg", 10)
        //集合中是否有对应下标的值有这个打印无则打印默认值
        println(people.elementAtOrElse(19, { per }))
        //查询集合下标无返回null、有则返回对应值
        println(people.elementAtOrNull(19))
        //查询集合最后一条 true 显示 false 显示 null
        println(people.findLast({ false }))
        //返回集合单一元素集合大于1则返回null
        println(people.singleOrNull())
        //集合中降序对应下标之后的所有元素
        println(people.drop(4))
        println(people.dropLast(2))
        println(people.filter({false}))
        //获取集合中最后的元素数量由下标决定
        println(people.takeLast(3))
        //集合逆序
        println(people.reversed())
    }
}