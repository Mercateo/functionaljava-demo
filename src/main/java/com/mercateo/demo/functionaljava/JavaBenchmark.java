package com.mercateo.demo.functionaljava;

import org.openjdk.jmh.annotations.Benchmark;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class JavaBenchmark {

    @Benchmark
    public static void filterPositiveNumbers(BenchmarkData data) {
        final List<Integer> list = data.getArrayList();
        list.stream().filter(x -> x > 5).collect(Collectors.toList());
    }

    @Benchmark
    public static void processNumbers(BenchmarkData data) {
        final List<Integer> array = data.getArrayList();

        final Long result = array.stream().map(Long::new).reduce(0L, (sum, value) -> sum + value);
    }

    @Benchmark
    public static void listAppendSingle(BenchmarkData data) {
        final LinkedList<Integer> list = data.getLinkedList();
        final LinkedList<Integer> array = new LinkedList<>(list);

        list.forEach(array::add);
    }

    @Benchmark
    public static void listAppend(BenchmarkData data) {
        final LinkedList<Integer> list = data.getLinkedList();

        final List<Integer> linkedList = new LinkedList<>(list);

        linkedList.addAll(list);
    }

    @Benchmark
    public static void arrayAppendSingle(BenchmarkData data) {
        final ArrayList<Integer> list = data.getArrayList();

        final ArrayList<Integer> array = new ArrayList<>(list);

        list.forEach(array::add);
    }

    @Benchmark
    public static void arrayAppend(BenchmarkData data) {
        final ArrayList<Integer> list = data.getArrayList();

        final ArrayList<Integer> array = new ArrayList<>(list);
        array.addAll(list);
    }

    @Benchmark
    public static void mapPutSingle(BenchmarkData data) {
        List<Integer> array = data.getArrayList();

        HashMap<String, Integer> map = data.getHashMap();
        for (Integer integer: array) {
            map.put(integer.toString(), integer);
        }
    }

    @Benchmark
    public static void concurrentMapPutSingle(BenchmarkData data) {
        List<Integer> array = data.getArrayList();

        ConcurrentHashMap<String, Integer> map = data.getConcurrentHashMap();
        for (Integer integer: array) {
            map.put(integer.toString(), integer);
        }
    }
}
