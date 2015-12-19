package com.mercateo.demo.functionaljava;

import javaslang.collection.Array;
import javaslang.collection.List;
import org.openjdk.jmh.annotations.Benchmark;

public class JavaSlangBenchmark {

    @Benchmark
    public static void filterPositiveNumbers(BenchmarkData data) {
        final Array<Integer> array = data.getJavaSlangArray();
        final Array<Integer> result = array.filter(x -> x > 0);
    }

    @Benchmark
    public static void listAppendSingle(BenchmarkData data) {
        final List<Integer> array = data.getJavaSlangList();

        List<Integer> result = array;
        for (Integer integer : array) {
            result = result.append(integer);
        }
    }

    @Benchmark
    public static void listAppend(BenchmarkData data) {
        final List<Integer> array = data.getJavaSlangList();
        final List<Integer> result = array.appendAll(array);
    }

    @Benchmark
    public static void arrayAppendSingle(BenchmarkData data) {
        final Array<Integer> array = data.getJavaSlangArray();

        Array<Integer> result = array;
        for (Integer integer : array) {
            result = result.append(integer);
        }
    }

    @Benchmark
    public static void arrayAppend(BenchmarkData data) {
        final Array<Integer> array = data.getJavaSlangArray();
        final Array<Integer> result = array.appendAll(array);
    }
}
