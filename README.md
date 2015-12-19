# Project functionaljava-demo

This project should be a playground for the evaluation of [Functional Java](http://www.functionaljava.org/)-Features.

## Benchmark results

Versions:

| Java | 1.8u60 |
| FJ | 4.4.1 |
| JavaSlang | 2.0.0-RC2 |
| Kotlin | 1.0.0-beta-3595 |

```
Benchmark                                       Mode  Cnt       Score        Error  Units
FunctionalJavaBenchmark.arrayAppend            thrpt    5  554453,890 ± 56690,973  ops/s
FunctionalJavaBenchmark.arrayAppendSingle      thrpt    5     762,641 ±    56,308  ops/s
FunctionalJavaBenchmark.filterPositiveNumbers  thrpt    5   40126,195 ±  1566,632  ops/s
FunctionalJavaBenchmark.listAppend             thrpt    5   76799,817 ±  5357,152  ops/s
FunctionalJavaBenchmark.listAppendSingle       thrpt    5      92,816 ±     4,123  ops/s
FunctionalJavaBenchmark.processNumbers         thrpt    5   58909,160 ±  3838,681  ops/s
JavaBenchmark.arrayAppend                      thrpt    5  278863,733 ± 52994,403  ops/s
JavaBenchmark.arrayAppendSingle                thrpt    5   52417,998 ± 13122,875  ops/s
JavaBenchmark.filterPositiveNumbers            thrpt    5   51158,292 ± 24743,647  ops/s
JavaBenchmark.listAppend                       thrpt    5   31811,319 ±  5363,774  ops/s
JavaBenchmark.listAppendSingle                 thrpt    5   31140,066 ±  1789,211  ops/s
JavaBenchmark.processNumbers                   thrpt    5   48216,384 ± 10537,142  ops/s
JavaSlangBenchmark.arrayAppend                 thrpt    5   58449,697 ± 32159,478  ops/s
JavaSlangBenchmark.arrayAppendSingle           thrpt    5     729,489 ±    61,404  ops/s
JavaSlangBenchmark.filterPositiveNumbers       thrpt    5   77471,631 ± 36949,531  ops/s
JavaSlangBenchmark.listAppend                  thrpt    5    8948,195 ±  4415,039  ops/s
JavaSlangBenchmark.listAppendSingle            thrpt    5       5,331 ±     3,921  ops/s
JavaSlangBenchmark.processNumbers              thrpt    5   36780,243 ± 26846,206  ops/s
```

