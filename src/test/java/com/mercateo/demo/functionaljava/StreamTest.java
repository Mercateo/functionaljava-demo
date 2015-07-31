package com.mercateo.demo.functionaljava;

import fj.data.Stream;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StreamTest {

    @Test
    public void testDropAndTake() {
        final Stream<Integer> stream = Stream.range(0, 10);
        assertThat(stream.drop(5).take(3)).containsExactly(5, 6, 7);
    }


}
