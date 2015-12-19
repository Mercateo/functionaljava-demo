package com.mercateo.demo.functionaljava;

import org.openjdk.jmh.annotations.Benchmark;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class KotlinBenchmarkDelegate {

    @Benchmark
    public static void filterPositiveNumbers(BenchmarkData data) {
        KotlinBenchmark.INSTANCE.filterPositiveNumbers(data);
    }

    @Benchmark
    public static void processNumbers(BenchmarkData data) {
        KotlinBenchmark.INSTANCE.processNumbers(data );
    }

    @Benchmark
    public static void listAppendSingle(BenchmarkData data) {
        KotlinBenchmark.INSTANCE.listAppendSingle(data);
    }

    @Benchmark
    public static void listAppendImmutableSingle(BenchmarkData data) {
        KotlinBenchmark.INSTANCE.listAppendImmutableSingle(data);
    }

    @Benchmark
    public static void listAppend(BenchmarkData data) {
        KotlinBenchmark.INSTANCE.listAppend(data);
    }

    @Benchmark
    public static void arrayAppendSingle(BenchmarkData data) {
        KotlinBenchmark.INSTANCE.arrayAppendSingle(data);
    }

    @Benchmark
    public static void arrayAppendImmutableSingle(BenchmarkData data) {
        KotlinBenchmark.INSTANCE.listAppendImmutableSingle(data);
    }

    @Benchmark
    public static void arrayAppend(BenchmarkData data) {
        KotlinBenchmark.INSTANCE.arrayAppend(data);
    }
}
