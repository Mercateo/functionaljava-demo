package com.mercateo.demo.functionaljava;

import fj.data.Array;
import fj.data.HashMap;
import fj.data.List;
import fj.data.TreeMap;
import org.openjdk.jmh.annotations.Benchmark;

@SuppressWarnings("unused")
public class FunctionalJavaBenchmark {

    @Benchmark
    public static void filterPositiveNumbers(BenchmarkData data) {
        final Array<Integer> array = data.getFunctionalJavaArray();

        final Array<Integer> result = array.filter(x -> x > 0);
    }

    @Benchmark
    public static void processNumbers(BenchmarkData data) {
        final Array<Integer> array = data.getFunctionalJavaArray();

        final Long result = array.map(Long::new).foldLeft((sum) -> (value) -> sum + value, 0L);
    }

    @Benchmark
    public static void listAppendImmutableSingle(BenchmarkData data) {
        final List<Integer> array = data.getFunctionalJavaList();

        final List<Integer> result = array.map(List::list).foldLeft((list) -> list::append, array);
    }

    @Benchmark
    public static void listAppend(BenchmarkData data) {
        final List<Integer> array = data.getFunctionalJavaList();

        final List<Integer> result = array.append(array);
    }

    @Benchmark
    public static void arrayAppendImmutableSingle(BenchmarkData data) {
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

    @Benchmark
    public static void mapPutSingle(BenchmarkData data) {
        final Array<Integer> array = data.getFunctionalJavaArray();

        final HashMap<String, Integer> map = data.getFunctionalJavaHashMap();
        for (Integer integer : array) {
            map.set(integer.toString(), integer);
        }
    }

    @Benchmark
    public static void mapPutImmutableSingle(BenchmarkData data) {
        final Array<Integer> array = data.getFunctionalJavaArray();

        TreeMap<String, Integer> map = data.getFunctionalJavaTreeMap();
        for (Integer integer : array) {
            map = map.set(integer.toString(), integer);
        }
    }
}
