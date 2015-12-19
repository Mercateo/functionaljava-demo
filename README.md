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
Benchmark                                            Mode  Cnt       Score        Error  Units
FunctionalJavaBenchmark.arrayAppend                 thrpt    5  987160,536 ±  58784,290  ops/s
FunctionalJavaBenchmark.arrayAppendImmutableSingle  thrpt    5     979,910 ±    392,312  ops/s
FunctionalJavaBenchmark.filterPositiveNumbers       thrpt    5   78631,816 ±  13786,520  ops/s
FunctionalJavaBenchmark.listAppend                  thrpt    5  103330,683 ±   6921,463  ops/s
FunctionalJavaBenchmark.listAppendImmutableSingle   thrpt    5     108,068 ±     12,464  ops/s
FunctionalJavaBenchmark.processNumbers              thrpt    5   83480,357 ±  26036,522  ops/s
JavaBenchmark.arrayAppend                           thrpt    5  375719,963 ± 141259,857  ops/s
JavaBenchmark.arrayAppendSingle                     thrpt    5   89235,228 ±  14272,456  ops/s
JavaBenchmark.filterPositiveNumbers                 thrpt    5  137167,303 ±  18690,496  ops/s
JavaBenchmark.listAppend                            thrpt    5   52493,223 ±  15582,388  ops/s
JavaBenchmark.listAppendSingle                      thrpt    5   50883,533 ±   3122,168  ops/s
JavaBenchmark.processNumbers                        thrpt    5  100866,487 ±  28959,954  ops/s
JavaSlangBenchmark.arrayAppend                      thrpt    5   85211,570 ±   6451,883  ops/s
JavaSlangBenchmark.arrayAppendImmutableSingle       thrpt    5     849,207 ±     56,130  ops/s
JavaSlangBenchmark.filterPositiveNumbers            thrpt    5  177783,391 ±  29507,543  ops/s
JavaSlangBenchmark.listAppend                       thrpt    5   12254,070 ±    560,995  ops/s
JavaSlangBenchmark.listAppendImmutableSingle        thrpt    5       7,997 ±      0,235  ops/s
JavaSlangBenchmark.processNumbers                   thrpt    5   67882,858 ±  14891,517  ops/s
KotlinBenchmarkDelegate.arrayAppend                 thrpt    5  449136,145 ± 247045,924  ops/s
KotlinBenchmarkDelegate.arrayAppendImmutableSingle  thrpt    5     569,386 ±    158,128  ops/s
KotlinBenchmarkDelegate.arrayAppendSingle           thrpt    5  134677,691 ± 108948,328  ops/s
KotlinBenchmarkDelegate.filterPositiveNumbers       thrpt    5  144325,537 ±  17962,978  ops/s
KotlinBenchmarkDelegate.listAppend                  thrpt    5   49273,233 ±   3398,363  ops/s
KotlinBenchmarkDelegate.listAppendImmutableSingle   thrpt    5     505,353 ±    237,400  ops/s
KotlinBenchmarkDelegate.listAppendSingle            thrpt    5   51664,250 ±   2917,111  ops/s
KotlinBenchmarkDelegate.processNumbers              thrpt    5  110837,059 ±   5438,408  ops/s
```

