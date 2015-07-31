package com.mercateo.demo.functionaljava;

import fj.F;
import fj.P;
import fj.P2;
import fj.data.Array;
import fj.data.Stream;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StreamTest {

    @Test
    public void testDropAndTake() {
        final Stream<Integer> stream = Stream.range(0, 10);
        assertThat(stream.drop(5).take(3)).containsExactly(5, 6, 7);
    }

    @Test
    public void testFibonacciIteration() {
        final P2<Integer, Integer> seed = P.p(1, 1);

        final F<P2<Integer, Integer>, P2<Integer, Integer>> step = p -> P.p(p._2(), p._1() + p._2());

        final Array<Integer> result = Stream
                .iterate(step, seed)
                .take(10)
                .map(P2::_1)
                .toArray();

        assertThat(result).containsExactly(1, 1, 2, 3, 5, 8, 13, 21, 34, 55);
    }

}
