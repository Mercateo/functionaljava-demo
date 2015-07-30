package com.mercateo.demo.functionaljava;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import fj.data.Array;

public class FjBenchmark {
    fj.data.Stream<Integer> test;

    Stream<Integer> test2;

    @Benchmark
    public static Array<Integer> fjFilterPositiveNumbers(Array<Integer> numbers) {
        return numbers.filter(x -> x > 5);
    }

    @Benchmark
    public static Array<Integer> fjAppend(Array<Integer> numbers, Array<Integer> otherNumbers) {
        return numbers.append(otherNumbers);
    }

    @Benchmark
    public static List<Integer> filterPositiveNumbers(List<Integer> numbers) {
        return numbers.stream().filter(x -> x > 5).collect(Collectors.toList());
    }

    @Benchmark
    public static List<Integer> filterPositiveNumbers(List<Integer> numbers,
            List<Integer> otherNumbers) {
        numbers.addAll(otherNumbers);
        return numbers.stream().filter(x -> x > 5).collect(Collectors.toList());
    }

    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder().warmupIterations(5)

        .measurementIterations(5)

        .forks(1)

        .build();

        new Runner(opt).run();

    }

    /*
     * ============================== HOW TO RUN THIS TEST:
     * ====================================
     * 
     * You can see the benchmark runs as usual.
     * 
     * You can run this test:
     * 
     * a) Via the command line: $ mvn clean install $ java -jar
     * target/benchmarks.jar JMHSample_04 -wi 5 -i 5 -f 1 (we requested 5
     * warmup/measurement iterations, single fork)
     * 
     * b) Via the Java API: (see the JMH homepage for possible caveats when
     * running from IDE: http://openjdk.java.net/projects/code-tools/jmh/)
     */
}
