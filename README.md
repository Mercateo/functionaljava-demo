# Project functionaljava-demo

This project should be a playground for the evaluation of [Functional Java](http://www.functionaljava.org/)-Features.

## Benchmark results

Versions:

Java: 1.8u60
FJ: 4.4.1
JavaSlang: 2.0.0-RC2

```
Benchmark                                       Mode  Cnt       Score        Error  Units
FunctionalJavaBenchmark.arrayAppend            thrpt    5  496691,403 ± 104689,012  ops/s
FunctionalJavaBenchmark.arrayAppendSingle      thrpt    5     654,952 ±    111,187  ops/s
FunctionalJavaBenchmark.filterPositiveNumbers  thrpt    5   42331,465 ±  11716,751  ops/s
FunctionalJavaBenchmark.listAppend             thrpt    5   60247,682 ±  23372,389  ops/s
FunctionalJavaBenchmark.listAppendSingle       thrpt    5      83,796 ±     12,545  ops/s
JavaBenchmark.arrayAppend                      thrpt    5  251592,781 ±  44199,680  ops/s
JavaBenchmark.arrayAppendSingle                thrpt    5   50859,764 ±  14312,018  ops/s
JavaBenchmark.filterPositiveNumbers            thrpt    5   50222,131 ±  13066,417  ops/s
JavaBenchmark.listAppend                       thrpt    5   35048,620 ±  15778,081  ops/s
JavaBenchmark.listAppendSingle                 thrpt    5   28058,214 ±   6422,887  ops/s
JavaSlangBenchmark.arrayAppend                 thrpt    5   58352,311 ±   5389,097  ops/s
JavaSlangBenchmark.arrayAppendSingle           thrpt    5     676,571 ±     41,834  ops/s
JavaSlangBenchmark.filterPositiveNumbers       thrpt    5   75510,279 ±  11963,837  ops/s
JavaSlangBenchmark.listAppend                  thrpt    5    9888,156 ±   2520,682  ops/s
JavaSlangBenchmark.listAppendSingle            thrpt    5       6,104 ±      1,953  ops/s
```

