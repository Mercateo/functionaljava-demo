package com.mercateo.demo.functionaljava;

import fj.data.Array;
import fj.data.List;
import org.openjdk.jmh.annotations.Benchmark;

public class FunctionalJavaBenchmark {

    @Benchmark
    public static void filterPositiveNumbers(BenchmarkData data) {
        final Array<Integer> array = data.getFunctionalJavaArray();
        final Array<Integer> result = array.filter(x -> x > 0);
    }

    @Benchmark
    public static void listAppendSingle(BenchmarkData data) {
        final List<Integer> array = data.getFunctionalJavaList();

        List<Integer> result = array;
        for (Integer integer : array) {
            result = result.append(List.list(integer));
        }
    }

    @Benchmark
    public static void listAppend(BenchmarkData data) {
        final List<Integer> array = data.getFunctionalJavaList();
        final List<Integer> result = array.append(array);
    }

    @Benchmark
    public static void arrayAppendSingle(BenchmarkData data) {
        final Array<Integer> array = data.getFunctionalJavaArray();

        Array<Integer> result = array;
        for (Integer integer : array) {
            result = result.append(Array.array(integer));
        }
    }

    @Benchmark
    public static void arrayAppend(BenchmarkData data) {
        final Array<Integer> array = data.getFunctionalJavaArray();
        final Array<Integer> result = array.append(array);
    }

}
