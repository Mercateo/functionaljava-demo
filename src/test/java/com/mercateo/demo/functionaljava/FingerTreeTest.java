package com.mercateo.demo.functionaljava;

import fj.Monoid;
import fj.data.fingertrees.Deep;
import fj.data.fingertrees.Empty;
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

    @Before
    public void setUp() {
        final Measured<Integer, String> measured = Measured.measured(Monoid.monoid(a -> b -> a + b, 0), String::length);
        final MakeTree<Integer, String> makeTree = FingerTree.mkTree(measured);
        tree = makeTree.empty();
    }

    @Test
    public void testEmptyTree() {
        assertThat(tree.isEmpty()).isTrue();
    }
}
