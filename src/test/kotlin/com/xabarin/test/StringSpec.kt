package com.xabarin.test

import com.xabarin.score
import io.kotlintest.specs.StringSpec

class StringSpec : StringSpec() {
    init{
        "Exact matches should score 1.0" {
            "Hello World".score("Hello World") shouldBe 1.0
        }

        "non-existint charactor in match should return 0" {
            "hello world".score("hello_world") shouldBe 0.0
            "hello world".score("hellx") shouldBe 0.0
        }

        "Matches out of order should return 0" {
            "hello world".score("WH") shouldBe 0.0
        }

        "Same case should match better then wrong case" {
            ("Hello World".score("hello") < "Hello World".score("Hello")) shouldBe true
        }

        "'He' should match 'Hello World' better then 'H' does" {
            ("Hello World".score("H") < "Hello World".score("He")) shouldBe true
        }

        "should match first matchable letter regardless of case" {
            ("Hillsdale Michigan".score("himi") > 0) shouldBe true
        }

        "shouldHaveProperRelativeWeighting" {
            ("hello world".score("e") < "hello world".score("h")) shouldBe true
            ("hello world".score("h") < "hello world".score("he")) shouldBe true
            ("hello world".score("hel") < "hello world".score("hell")) shouldBe true
            ("hello world".score("hell") < "hello world".score("hello")) shouldBe true
            ("hello world".score("hello") < "hello world".score("helloworld")) shouldBe true
            ("hello world".score("helloworl") < "hello world".score("hello worl")) shouldBe true
        }

        "'Hel' should match 'Hello World' better then 'Hld'" {
            ("Hello World".score("Hel") > "Hello World".score("Hld")) shouldBe true
        }

        "'HW' should score higher with 'Hello World' then 'Ho'" {
            ("yet another Hello World".score("yaHW") > "Hello World".score("yet another")) shouldBe true
        }

        "'HiMi' should match 'Hillsdale Michigan' higher then 'Hil'" {
            ("Hillsdale Michigan".score("HiMi") > "Hillsdale Michigan".score("Hil")) shouldBe true
            ("Hillsdale Michigan".score("HiMi") > "Hillsdale Michigan".score("illsda")) shouldBe true
            ("Hillsdale Michigan".score("HiMi") > "Hillsdale Michigan".score("hills")) shouldBe true
            ("Hillsdale Michigan".score("HiMi") < "Hillsdale Michigan".score("hillsd")) shouldBe true
        }

        "beginningOfStringBonus" {
            ("Hillsdale".score("hi") > "Chippewa".score("hi")) shouldBe true
        }

        "should have a bonus for matching first letter" {
            ("hello world".score("h") > "hello world".score("w")) shouldBe true
        }

        "'res' matches 'Mary Conces' better then 'Research Resources North'" {
            ("Research Resources North".score("res") > "Mary Conces".score("res")) shouldBe true
            ("Research Resources North".score("res") > "Bonnie Strathern - Southwest Michigan Title Search".score("res")) shouldBe true
        }

        "startOfStringBonus" {
            ("Mary Large".score("mar") > "Large Mary".score("mar")) shouldBe true
        }

        "ensure start of string bonus only on start of string" {
            ("Silly Mary Large".score("mar") == "Silly Large Mary".score("mar")) shouldBe true
        }

        "should score 0 without a specified fuzziness." {
            "Hello World".score("Hz") shouldBe 0.0
        }

        "fuzzy matches should be worse then good ones" {
            ("Hello World".score("Hz", 0.5) < "Hello World".score("H", 0.5)) shouldBe true
        }

        "mismatch should always be worse" {
            ("hello world".score("hello worl", 0.5) > "hello world".score("hello wor1", 0.5)) shouldBe  true
        }

        "'Hello World' should match 'jello' more then 0 with a fuzziness of 0.5" {
            ("Hello World".score("jello", 0.5) > 0) shouldBe true
        }

        "higher fuzziness should yield higher scores" {
            ("Hello World".score("Hz", 0.9) > "Hello World".score("Hz", 0.5)) shouldBe true
        }
    }
}
