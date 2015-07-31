package com.mercateo.demo.functionaljava;

import fj.data.hlist.HList;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HListTest {

    @Test
    public void testSimpleHlist() {
        String string = "foo";
        final HList.HCons<String, HList.HNil> singleElementList = HList.single(string);

        Float number = 4.2f;
        final HList.HCons<Float, HList.HCons<String, HList.HNil>> doubleElementList = HList.cons(number, singleElementList);

        assertThat(doubleElementList.head()).isEqualTo(number);
        assertThat(doubleElementList.tail().head()).isEqualTo(string);
    }
}
