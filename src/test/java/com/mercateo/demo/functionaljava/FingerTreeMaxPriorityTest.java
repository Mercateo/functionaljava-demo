package com.mercateo.demo.functionaljava;

import fj.Monoid;
import fj.data.fingertrees.FingerTree;
import fj.data.fingertrees.MakeTree;
import fj.data.fingertrees.Measured;
import fj.data.fingertrees.One;
import lombok.Data;
import lombok.val;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FingerTreeMaxPriorityTest {

    public static final int ZERO_ELEMENT = Integer.MIN_VALUE;

    private FingerTree<Integer, Task> tree;
    private MakeTree<Integer, Task> mk;

    @Data
    public static class Task {
        private final String name;
        private final Integer priority;
    }

    @Before
    public void setUp() {
        final Measured<Integer, Task> measured = Measured.measured(Monoid.monoid(a -> b -> measurement(a, b), ZERO_ELEMENT), Task::getPriority);
        mk = FingerTree.mkTree(measured);
        tree = mk.empty();
    }

    private Integer measurement(Integer a, Integer b) {
        if (a == ZERO_ELEMENT) {
            return b;
        }
        if (b == ZERO_ELEMENT) {
            return a;
        }
        return Math.max(a, b);
    }

    @Test
    public void testEmptyTree() {
        assertThat(tree.isEmpty()).isTrue();
    }

    @Test
    public void testTree() {
        val updatedTree = createBaseTree();

        assertThat(updatedTree.measure()).isEqualTo(10);
        assertThat(updatedTree.isEmpty()).isFalse();
        assertThat(updatedTree.head().getName()).isEqualTo("baz");
        assertThat(updatedTree.last().getName()).isEqualTo("foo");
    }

    @Test
    public void test() {
        FingerTree<Integer, Task> updatedTree;

        updatedTree = tree.append(mk.single(new Task("foo", 10)));

        assertThat(updatedTree.head().getName()).isEqualTo("foo");

        updatedTree = tree.append(mk.single(new Task("bar", 20)));

        assertThat(updatedTree.head().getName()).isEqualTo("bar");

        updatedTree = tree.append(mk.single(new Task("baz", 5)));

        assertThat(updatedTree.head().getName()).isEqualTo("baz");
    }

    @Test
    public void testTreeAddHigherPriority() {
        val updatedTree = createBaseTree().cons(new Task("high", 20));

        assertThat(updatedTree.measure()).isEqualTo(20);
        assertThat(updatedTree.isEmpty()).isFalse();
        assertThat(updatedTree.head().getName()).isEqualTo("baz");
        assertThat(updatedTree.last().getName()).isEqualTo("foo");
    }

    private FingerTree<Integer, Task> createBaseTree() {
        return tree.cons(new Task("foo", 10)).cons(new Task("bar", -5)).cons(new Task("baz", 0));
    }
}
