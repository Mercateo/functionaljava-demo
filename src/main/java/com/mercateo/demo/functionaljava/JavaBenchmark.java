package com.mercateo.demo.functionaljava;

import org.openjdk.jmh.annotations.Benchmark;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class JavaBenchmark {

    @Benchmark
    public static void filterPositiveNumbers(BenchmarkData data) {
        final List<Integer> list = data.getArrayList();
        list.stream().filter(x -> x > 5).collect(Collectors.toList());
    }

    @Benchmark
    public static void listAppendSingle(BenchmarkData data) {
        final LinkedList<Integer> list = data.getLinkedList();
        final LinkedList<Integer> array = new LinkedList<>(list);

        for (Integer integer : list) {
            array.add(integer);
        }
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

        for (Integer integer : list) {
            array.add(integer);
        }
    }

    @Benchmark
    public static void arrayAppend(BenchmarkData data) {
        final ArrayList<Integer> list = data.getArrayList();
        final ArrayList<Integer> array = new ArrayList<>(list);
        array.addAll(list);
    }
}
