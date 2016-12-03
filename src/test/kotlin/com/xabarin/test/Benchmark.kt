package com.xabarin.test

import com.xabarin.score
import io.kotlintest.specs.StringSpec

class Benchmark : StringSpec() {
    init{
        val iterations = 4000

        "iterations of score(\"hello world\", \"h\"" {

            val start = System.currentTimeMillis()
            for (iteration in 1..iterations) {
                "hello world".score("h")
            }
            val end = System.currentTimeMillis()
            val time = end - start

            println(time.toString() + " milliseconds to do " + iterations + " iterations of score(\"hello world\", \"h\")")
        }

        "iterations of score(\"hello world\", \"hw\")" {

            val start = System.currentTimeMillis()
            for (iteration in 1..iterations) {
                "hello world".score("hw")
            }
            val end = System.currentTimeMillis()
            val time = end - start

            println(time.toString() + " milliseconds to do " + iterations + " iterations of score(\"hello world\", \"h\")")
        }

        "iterations of score(\"hello world\", \" iterations of score(\"hello world\", \"hello world\")\")" {

            val start = System.currentTimeMillis()
            for (iteration in 1..iterations) {
                "hello world".score("hello world")
            }
            val end = System.currentTimeMillis()
            val time = end - start

            println(time.toString() + " milliseconds to do " + iterations + " iterations of score(\"hello world\", \" iterations of score(\"hello world\", \"hello world\")\")")
        }

        "iterations of score(\"hello any world that will listen\", \"hlo wrdthlstn\")" {

            val start = System.currentTimeMillis()
            for (iteration in 1..iterations) {
                "hello any world that will listen".score("hlo wrdthlstn")
            }
            val end = System.currentTimeMillis()
            val time = end - start

            println(time.toString() + " milliseconds to do " + iterations + " iterations of score(\"hello any world that will listen\", \"hlo wrdthlstn\")")
        }

        "iterations of 446 character string scoring a 70 character match" {

            val start = System.currentTimeMillis()
            for (iteration in 1..iterations) {
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
                        .score("Lorem i dor coecadipg et, Duis aute irure dole nulla. qui ofa mot am l")
            }
            val end = System.currentTimeMillis()
            val time = end - start

            println(time.toString() + " milliseconds to do " + iterations + "iterations of 446 character string scoring a 70 character match")
        }
    }
}