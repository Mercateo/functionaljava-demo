# Project functionaljava-demo

This project should be a playground for the evaluation of functional extensions to the Java Language or the JVM like 

 * [Functional Java](http://www.functionaljava.org/)
 * [JavaSlang](http://javaslang.com/)
 * [Kotlin](http://kotlinlang.org/)

## Benchmark results

| Method                     | Java | FunctionalJava | JavaSlang | Kotlin |
| -------------------------- | ---- | -------------- | --------- | ------ |
| arrayAppend                | 1.0  | 2.0            | 0.1       | 1.0    |
| arrayAppendSingle          | 1.0  | --             | --        | 1.1    |
| arrayAppendImmutableSingle | --   | 1.0            | 1.0       | 1.03   |
| listAppend                 | 1.0  | 1.8            | 1.6       | 1.0    |
| listAppendSingle           | 1.0  | --             | --        | 1.1    |
| listAppendImmutableSingle  | --   | 1.0            | 0.3       | 5.5    |
| filterPositiveNumbers      | 1.0  | 1.0            | 1.1       | 1.1    |
| processNumbers             | 1.0  | 0.9            | 0.72      | 1.1    |


Versions:

|           |           |
| --------- | --------- |
| Java      | 1.8u121   |
| FJ        | 4.6       |
| JavaSlang | 2.0.5     |
| Kotlin    | 1.0.6     |


