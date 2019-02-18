package com.demo.mg.mykotlin.utils

import org.junit.Test

import org.junit.Assert.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class TestHttpTest {

    @Test
    fun http() {


        Thread(Runnable {

            var connection: HttpURLConnection? = null
            var reader: BufferedReader? = null

            val url = URL("http://www.baidu.com")
            connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "GET"
            connection.connectTimeout = 8000
            connection.readTimeout = 8000

            val inStream = connection.inputStream
            reader = BufferedReader(InputStreamReader(inStream))
            val response = StringBuilder()
            val allText = reader.use(BufferedReader::readText)
            response.append(allText)
            System.out.print(response.toString())
        }).start()
    }
}