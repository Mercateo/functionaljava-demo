package com.mercateo.demo.functionaljava;

import fj.*;
import fj.data.Array;
import fj.data.Set;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class SemigroupTest {

    @Test
    public void testSemigroup() {
        final BigDecimal sum = Semigroup.bigdecimalAdditionSemigroup.sum(new BigDecimal("10.1"), new BigDecimal("5.2"));
        assertThat(sum).isEqualTo("15.3");
    }

    @Test
    public void testSemigroupApplyAll() {
        final F<BigDecimal, F<BigDecimal, BigDecimal>> addUp = Semigroup.bigdecimalAdditionSemigroup.sum();

        final BigDecimal result = Array.array(new BigDecimal("2.0"), new BigDecimal("4.0")).foldLeft(addUp, new BigDecimal("0.0"));

        assertThat(result).isEqualTo("6.0");
    }

    @Test
    public void testSemigroupApply() {
        final F<BigDecimal, BigDecimal> multiplyBy = Semigroup.bigdecimalMultiplicationSemigroup.sum(new BigDecimal("2.5"));

        final Array<BigDecimal> map = Array.array(new BigDecimal("2.0"), new BigDecimal("4.0")).map(multiplyBy);
        assertThat(map).containsExactly(new BigDecimal("5.00"), new BigDecimal("10.00"));
    }

    @Test
    public void testMapSemigroup() {
        final Semigroup<Map<Integer, Integer>> semigroup = Semigroup.semigroup(new F2<Map<Integer, Integer>, Map<Integer, Integer>, Map<Integer, Integer>>() {
            @Override
            public Map<Integer, Integer> f(Map<Integer, Integer> leftMap, Map<Integer, Integer> rightMap) {
                final Set<Integer> keys = Set.iterableSet(Ord.intOrd, leftMap.keySet()).union(Set.iterableSet(Ord.intOrd, rightMap.keySet()));
                return fj.data.HashMap.from(keys.map(Ord.p2Ord(Ord.intOrd, Ord.intOrd), k -> new P2<Integer, Integer>() {
                    @Override
                    public Integer _1() {
                        return k;
                    }

                    @Override
                    public Integer _2() {
                        return leftMap.getOrDefault(k, 0) + rightMap.getOrDefault(k, 0);
                    }
                })).toMap();
            }
        });

        Map<Integer, Integer> map1 = new HashMap<>();
        map1.put(1, 2);
        map1.put(2, 3);

        Map<Integer, Integer> map2 = new HashMap<>();
        map2.put(2, 2);
        map2.put(3, 3);

        final Map<Integer, Integer> result = semigroup.sum(map1, map2);

        assertThat(result).containsEntry(1, 2).containsEntry(2, 5).containsEntry(3, 3);
    }

}
