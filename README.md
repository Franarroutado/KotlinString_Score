# What is it

- This is Kotlin port of Joshaven Potter's string_score. String Scoring Algorithm __0.1.22__
- Add an extension in Kotlin String class

## Installation Notes

This code was developed using:
- __Gradle__ 3.1  
- __Kotlin:__ 1.0.5  
- [__Kotlintest__](https://github.com/kotlintest/) 1.3.5

## Examples

Add the source code into your project.

```
"Derideo Te".score("dt") //=> 0.63
"Derideo Te".score("DT") //=> 0.69

"Derideo Te".score("derideo") //=> 0.8178571428571427
"Derideo Te".score("Derideo") //=> 0 0.83
```

## Tests and Benchmark

My tests & Benchmark are ported from [Shingo Omura's java version](https://github.com/everpeace/string-score).

> $> gradle test
