package com.mercateo.demo.functionaljava;

import javaslang.collection.*;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.*;
import java.util.List;

@State(Scope.Benchmark)
public class BenchmarkData {

    private final fj.data.Array<Integer> functionalJavaArray;
    private final javaslang.collection.Array<Integer> javaSlangArray;
    private final ArrayList<Integer> arrayList;
    private final javaslang.collection.List<Integer> javaSlangList;
    private final fj.data.List<Integer> functionalJavaList;
    private final LinkedList<Integer> linkedList;

    public BenchmarkData() {
        final int size = 1000;
        final int maximum = 100;
        final int minimum = -100;

        final Integer[] data = new Integer[size];
        for (int i = 0; i < size; i++) {

            Random rn = new Random();
            int range = maximum - minimum + 1;
            data[i] = rn.nextInt(range) + minimum;
        }

        final List<Integer> dataList = Arrays.asList(data);
        arrayList = new ArrayList<>(dataList);
        linkedList = new LinkedList<>(dataList);

        functionalJavaArray = fj.data.Array.array(data);
        functionalJavaList = fj.data.List.list(data);

        javaSlangArray = javaslang.collection.Array.of(data);
        javaSlangList = javaslang.collection.List.of(data);
    }

    public ArrayList<Integer> getArrayList() {
        return arrayList;
    }

    public LinkedList<Integer> getLinkedList() {
        return linkedList;
    }

    public fj.data.Array<Integer> getFunctionalJavaArray() {
        return functionalJavaArray;
    }

    public fj.data.List<Integer> getFunctionalJavaList() {
        return functionalJavaList;
    }

    public javaslang.collection.Array<Integer> getJavaSlangArray() {
        return javaSlangArray;
    }

    public javaslang.collection.List<Integer> getJavaSlangList() {
        return javaSlangList;
    }

}
