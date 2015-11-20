package com.mercateo.demo.functionaljava;

import fj.function.Integers;
import javaslang.collection.Array;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayJavaSlangTest {

    @Test
    public void testMutabilityIsNotGiven() {
        final Array<Integer> array = Array.range(0, 3);
        array.removeAt(1);
        array.insert(1, 1);
        assertThat(array).containsExactly(0, 1, 2);
    }

    @Test
    public void testInterfacingToNativeType() {
        final Array<Integer> array = Array.range(0, 3);

        final Collection<Integer> collection = array.toJavaList();
        assertThat(collection).containsExactly(0, 1, 2);

        final List<Integer> list = array.toList().toJavaList();
        assertThat(list).containsExactly(0, 1, 2);

        final Integer[] intArray = array.toJavaArray(Integer.class);
        assertThat(intArray).containsExactly(0, 1, 2);

        final Iterator<Integer> iterator = array.iterator();
        assertThat(iterator).containsExactly(0, 1, 2);
    }

    @Test
    public void testInterfacingFromNativeTypes() {
        List<Integer> integerList = Arrays.asList(0, 1, 2);
        assertThat(Array.ofAll(integerList)).containsExactly(0, 1, 2);

        final Integer[] integerArray = {0, 1, 2};
        assertThat(Array.ofAll(integerArray)).containsExactly(0, 1, 2);
    }

    @Test
    public void testAppend() {
        final Array<Integer> array1 = Array.range(0, 3);
        final Array<Integer> array2 = Array.range(3, 6);

        final Array<Integer> array3 = array1.appendAll(array2);

        assertThat(array3).containsExactly(0, 1, 2, 3, 4, 5);
    }

    @Test
    public void testFoldLeft() {
        final Array<Integer> array = Array.range(0, 10);
        assertThat(array.foldLeft(0, (Integer i1, Integer i2) -> i1 + i2)).isEqualTo(45);
    }

    @Test
    public void testScanLeft() {
        final Array<Integer> array = Array.range(0, 10);
    }

}
