package com.mercateo.demo.functionaljava;

import fj.data.Array;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayTest {

    @Test
    public void testAppend() {
        final Array<Integer> array1 = Array.range(0, 3);
        final Array<Integer> array2 = Array.range(3, 6);

        final Array<Integer> array3 = array1.append(array2);

        assertThat(array3).containsExactly(0, 1, 2, 3, 4, 5);
    }

    @Test
    public void testFoldLeft() {
        final Array<Integer> array = Array.range(0, 10);

        assertThat(array.foldLeft((Integer i1) -> (Integer i2) -> i1 + i2, 0)).isEqualTo(45);
        assertThat(array.foldLeft((Integer i1, Integer i2) -> i1 + i2, 0)).isEqualTo(45);
    }

    @Test
    public void testScanLeft() {
        final Array<Integer> array = Array.range(0, 10);

        assertThat(array.scanLeft((i1) -> (i2) -> i1 + i2, 0)).containsExactly(0,
                1, 3, 6, 10, 15, 21, 28, 36, 45);

        assertThat(array.scanLeft((i1, i2) -> i1 + i2, 0)).containsExactly(0,
                1, 3, 6, 10, 15, 21, 28, 36, 45);
    }
}
