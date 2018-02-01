package com.mercateo.demo.functionaljava;

import io.vavr.collection.Array;
import io.vavr.collection.HashMap;
import io.vavr.collection.List;
import io.vavr.control.Option;
import org.openjdk.jmh.annotations.Benchmark;

import java.util.concurrent.ConcurrentHashMap;

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
    public static void removeAppendImmutableSingle(BenchmarkData data) {
        Array<Integer> array = data.getJavaSlangArray();

        for (Integer integer : array) {
            array = array.remove(integer);
        }
    }

    @Benchmark
    public static void arrayAppend(BenchmarkData data) {
        final Array<Integer> array = data.getJavaSlangArray();

        final Array<Integer> result = array.appendAll(array);
    }

    @Benchmark
    public static void mapPutImmutableSingle(BenchmarkData data) {
        final Array<Integer> array = data.getJavaSlangArray();

        HashMap<String, Integer> map = data.getJavaSlangMap();
        for (Integer integer : array) {
            map = map.put(integer.toString(), integer);
        }
    }

    @Benchmark
    public static void mapGet(BenchmarkData data) {
        HashMap<String, Integer> map = data.getJavaSlangInitializedMap();

        for (String key : map.keySet()) {
            Option<Integer> integer = map.get(key);
        }
    }
}
