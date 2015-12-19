# Project functionaljava-demo

This project should be a playground for the evaluation of functional extensions to the Java Language or the JVM like 

 * [Functional Java](http://www.functionaljava.org/)
 * [JavaSlang](http://javaslang.com/)
 * [Kotlin](http://kotlinlang.org/)

## Benchmark results

| Method                     | Java | FunctionalJava | JavaSlang | Kotlin |
| -------------------------- | ---- | -------------- | --------- | ------ |
| arrayAppend                | 1.0  | 1.84           | 0.23      | 1.00   |
| arrayAppendSingle          | 1.0  | --             | --        | 1.33   |
| arrayAppendImmutableSingle |      | 1.0            | 0.95      | 1.00   |
| listAppend                 | 1.0  | 2.22           | 0.31      | 0.98   |
| listAppendSingle           | 1.0  | --             | --        | 1.12   |
| listAppendImmutableSingle  |      | 1.0            | 0.07      | 4.01   |
| filterPositiveNumbers      | 1.0  | 0.84           | 1.50      | 1.20   |
| processNumbers             | 1.0  | 1.20           | 1.00      | 1.59   |


Versions:

| ---- | ------- |
| Java | 1.8u60 |
| FJ | 4.4.1 |
| JavaSlang | 2.0.0-RC2 |
| Kotlin | 1.0.0-beta-3595 |
