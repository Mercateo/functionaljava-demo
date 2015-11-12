package com.mercateo.demo.functionaljava;

import fj.data.Seq;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SequenceTest {

    private Seq<String> seq;

    @Before
    public void setUp() {
        seq = Seq.empty();
    }

    @Test
    public void addFirstElement() {
        assertThat(seq).isEmpty();

        seq = seq.cons("foo");

        assertThat(seq).hasSize(1);
    }

    @Test
    public void addElements() {
        assertThat(seq).isEmpty();

        seq = seq.cons("one").cons("two").cons("three").cons("four");

        assertThat(seq).hasSize(4);
    }
}
