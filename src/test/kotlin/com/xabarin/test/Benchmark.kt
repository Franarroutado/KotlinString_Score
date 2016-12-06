package com.xabarin.test

import com.xabarin.score
import io.kotlintest.specs.StringSpec
import kotlin.system.measureTimeMillis

class Benchmark : StringSpec() {
    init{
        val iterations = 4000

        "Benchmark test" {

            println("iterations of score(\"hello world\", \"h\"")
            val time1 = measureTimeMillis {
                for (iteration in 1..iterations) {
                    "hello world".score("h")
                }
            }
            println("$time1 milliseconds to do $iterations iterations of score(\"hello world\", \"h\")")


            println("iterations of score(\"hello world\", \"hw\")")
            val time2 = measureTimeMillis {
                for (iteration in 1..iterations) {
                    "hello world".score("hw")
                }
            }
            println("$time2 milliseconds to do $iterations iterations of score(\"hello world\", \"h\")")


            println("iterations of score(\"hello world\", \" iterations of score(\"hello world\", \"hello world\")\")")
            val time3 = measureTimeMillis {
                for (iteration in 1..iterations) {
                    "hello world".score("hello world")
                }
            }
            println("$time3 milliseconds to do $iterations iterations of score(\"hello world\", \" iterations of score(\"hello world\", \"hello world\")\")")


            println("iterations of score(\"hello any world that will listen\", \"hlo wrdthlstn\")")
            val time4 = measureTimeMillis {
                for (iteration in 1..iterations) {
                    "hello any world that will listen".score("hlo wrdthlstn")
                }
            }
            println("$time4 milliseconds to do $iterations iterations of score(\"hello any world that will listen\", \"hlo wrdthlstn\")")


            println("iterations of 446 character string scoring a 70 character match")
            val time5 = measureTimeMillis {
                for (iteration in 1..iterations) {
                    "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
                            .score("Lorem i dor coecadipg et, Duis aute irure dole nulla. qui ofa mot am l")
                }
            }
            println("$time5 milliseconds to do $iterations iterations of 446 character string scoring a 70 character match")

            println("Average Score... all benchmarks devided by the number of benchmarks (smaller is faster): ${time1+time2+time3+time4+time5} milliseconds")

        }
    }
}