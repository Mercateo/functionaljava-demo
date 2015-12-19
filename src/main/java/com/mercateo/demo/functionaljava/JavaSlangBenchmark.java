package com.mercateo.demo.functionaljava;

import javaslang.collection.Array;
import javaslang.collection.List;
import org.openjdk.jmh.annotations.Benchmark;

@SuppressWarnings("unused")
public class JavaSlangBenchmark {

    @Benchmark
    public static void filterPositiveNumbers(BenchmarkData data) {
        final Array<Integer> array = data.getJavaSlangArray();

        final Array<Integer> result = array.filter(x -> x > 0);
    }

    @Benchmark
    public static void processNumbers(BenchmarkData data) {
        final Array<Integer> array = data.getJavaSlangArray();

        final Long result = array.map(Long::new).foldLeft(0L, (sum, value) -> sum + value);
    }

    @Benchmark
    public static void listAppendImmutableSingle(BenchmarkData data) {
        final List<Integer> list = data.getJavaSlangList();

        final List<Integer> result = list.foldLeft(list, List::append);
    }

    @Benchmark
    public static void listAppend(BenchmarkData data) {
        final List<Integer> list = data.getJavaSlangList();

        final List<Integer> result = list.appendAll(list);
    }

    @Benchmark
    public static void arrayAppendImmutableSingle(BenchmarkData data) {
        final Array<Integer> array = data.getJavaSlangArray();

        final Array<Integer> result = array.foldLeft(array, Array::append);
    }

    @Benchmark
    public static void arrayAppend(BenchmarkData data) {
        final Array<Integer> array = data.getJavaSlangArray();

        final Array<Integer> result = array.appendAll(array);
    }
}
