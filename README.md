# Project functionaljava-demo

This project should be a playground for the evaluation of functional extensions to the Java Language or the JVM like 

 * [Functional Java](http://www.functionaljava.org/)
 * [JavaSlang](http://javaslang.com/)
 * [Kotlin](http://kotlinlang.org/)

## Benchmark results

| Method                     | Java | FunctionalJava | JavaSlang | Kotlin |
| -------------------------- | ---- | -------------- | --------- | ------ |
| arrayAppend                | 1.0  | 2.4            | 0.2       | 1.0    |
| arrayAppendSingle          | 1.0  | --             | --        | 1.3    |
| arrayAppendImmutableSingle | --   | 1.0            | 1.0       | 1.00   |
| listAppend                 | 1.0  | 2.1            | 0.8       | 1.1    |
| listAppendSingle           | 1.0  | --             | --        | 1.3    |
| listAppendImmutableSingle  | --   | 1.0            | 0.1       | 6.7    |
| filterPositiveNumbers      | 1.0  | 0.5            | 1.4       | 1.1    |
| processNumbers             | 1.0  | 0.9            | 0.75      | 1.2   |


Versions:

|           |           |
| --------- | --------- |
| Java      | 1.8u72    |
| FJ        | 4.5       |
| JavaSlang | 2.0.0-RC4 |
| Kotlin    | 1.0.1     |


