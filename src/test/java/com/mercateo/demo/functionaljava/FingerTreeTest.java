package com.mercateo.demo.functionaljava;

import fj.Monoid;
import fj.data.fingertrees.FingerTree;
import fj.data.fingertrees.MakeTree;
import fj.data.fingertrees.Measured;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * see: http://staff.city.ac.uk/~ross/papers/FingerTree.html
 */
public class FingerTreeTest {

    private FingerTree<Integer, String> tree;
    private MakeTree<Integer, String> mkTree;

    @Before
    public void setUp() {
        final Measured<Integer, String> measured = Measured.measured(Monoid.monoid(a -> b -> measurement(a, b), 0), String::length);
        mkTree = FingerTree.mkTree(measured);
        tree = mkTree.empty();
    }

    private Integer measurement(Integer a, Integer b) {
        return a == 0 ? b : (b == 0 ? a : Math.min(a, b));
    }

    @Test
    public void testEmptyTree() {
        assertThat(tree.isEmpty()).isTrue();
    }

    @Test
    public void testTree() {
        assertThat(tree.isEmpty()).isTrue();

        final FingerTree<Integer, String> updatedTree = tree.cons("t").cons("te").cons("tes").cons("test").cons("tests");

        assertThat(updatedTree.measure()).isEqualTo(1);
        assertThat(updatedTree.isEmpty()).isFalse();
        assertThat(updatedTree.head()).isEqualTo("test");
        assertThat(updatedTree.tail()).isEqualTo("test");
    }

    @Test
    public void testTreeAppend() {
        final FingerTree<Integer, String> updatedTree = tree.append(mkTree.single("t")).append(mkTree.single("te")).append(mkTree.single("tes")).append(mkTree.single("test"));

        assertThat(tree.isEmpty()).isTrue();
        assertThat(updatedTree.isEmpty()).isFalse();
        assertThat(updatedTree.head()).isEqualTo("test");
        assertThat(updatedTree.tail()).isEqualTo("test");
    }
}
