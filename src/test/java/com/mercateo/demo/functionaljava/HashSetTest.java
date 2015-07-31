package com.mercateo.demo.functionaljava;

import fj.Equal;
import fj.Hash;
import fj.data.Array;
import fj.data.HashSet;
import org.junit.Test;

import static java.lang.Math.abs;
import static org.assertj.core.api.Assertions.assertThat;

public class HashSetTest {

    @Test
    public void testHashSet() {
        final HashSet<Integer> integerSet = new HashSet<>(Equal.intEqual, Hash.intHash);
        Array.range(0, 10).forEach(integerSet::set);

        assertThat(integerSet).containsExactly(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @Test
    public void testHashSetWithIndividualHashAndEquals() {
        final HashSet<Integer> integerSet = new HashSet<>(
                Equal.equal(i1 -> i2 -> abs(i1) == abs(i2)),
                Hash.hash(integer -> Integer.valueOf(abs(integer)).hashCode())
        );
        Array.range(0, 10).forEach(integerSet::set);
        Array.range(-9, 1).forEach(integerSet::set);

        // Values with identical HashCode and Equality are not replaced
        assertThat(integerSet).containsExactly(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }
}
