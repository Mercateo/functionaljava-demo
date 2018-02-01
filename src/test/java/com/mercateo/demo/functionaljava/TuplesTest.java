package com.mercateo.demo.functionaljava;

import io.vavr.Tuple;
import io.vavr.Tuple4;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class TuplesTest {

    @Test
    public void testTuple() {
        final Tuple4<String, Double, Long, Boolean> tuple = Tuple.of("Name", 2.3, 1L, true);

        assertThat(tuple._1).isEqualTo("Name");
        assertThat(tuple._2).isEqualTo(2.3);
        assertThat(tuple._3).isEqualTo(1L);
        assertThat(tuple._4).isTrue();
    }
}
