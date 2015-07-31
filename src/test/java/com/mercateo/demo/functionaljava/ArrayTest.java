package com.mercateo.demo.functionaljava;

import fj.Ord;
import fj.data.Array;
import fj.data.HashSet;
import fj.data.Set;
import fj.function.Integers;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayTest {

    @Test
    public void testInterfacingToNativeType() {
        final Array<Integer> array = Array.range(0, 3);

        final Collection<Integer> collection = array.toCollection();
        assertThat(collection).containsExactly(0, 1, 2);

        final List<Integer> list = array.toList().toJavaList();
        assertThat(list).containsExactly(0, 1, 2);

        final Integer[] intArray = array.array(Integer[].class);
        assertThat(intArray).containsExactly(0, 1, 2);

        final Iterator<Integer> iterator = array.iterator();
        assertThat(iterator).containsExactly(0, 1, 2);
    }

    @Test
    public void testInterfacingFromNativeTypes() {
        List<Integer> integerList = Arrays.asList(0, 1, 2);
        assertThat(Array.iterableArray(integerList)).containsExactly(0, 1, 2);

        final Integer[] integerArray = {0, 1, 2};
        assertThat(Array.array(integerArray)).containsExactly(0, 1, 2);
    }

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
        assertThat(array.foldLeft(Integers.add, 0)).isEqualTo(45);
    }

    @Test
    public void testScanLeft() {
        final Array<Integer> array = Array.range(0, 10);

        assertThat(array.scanLeft((i1) -> (i2) -> i1 + i2, 0)).containsExactly(0,
                1, 3, 6, 10, 15, 21, 28, 36, 45);

        assertThat(array.scanLeft((i1, i2) -> i1 + i2, 0)).containsExactly(0,
                1, 3, 6, 10, 15, 21, 28, 36, 45);
    }

    @Test
    public void testBind() {
        final Array<Integer> array = Array.range(0, 2);
        final Array<Integer> reversedNegatedArray = array.reverse().map(Integers.negate);

        assertThat(array.bind(reversedNegatedArray, Integers.add)).containsExactly(-1, 0, 0, 1);
    }


}
