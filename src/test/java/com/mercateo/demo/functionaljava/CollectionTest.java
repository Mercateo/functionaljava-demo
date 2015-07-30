package com.mercateo.demo.functionaljava;

import fj.F2;
import fj.data.Array;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CollectionTest {
  @Test
  public void testCollections() {
    final Array<Integer> range = Array.range( 0, 10 );

    assertThat( range.scanLeft( ( integer, integer2 ) -> integer + integer2, 0 )
    ).isEqualTo( 5 );
  }

  @Test
  public void testAppend() {
    final Array<Integer> array1 = Array.range( 0, 3 );
    final Array<Integer> array2 = Array.range( 3, 6 );

    final Array<Integer> array3 = array1.append( array2 );

    assertThat( array3 ).containsExactly( 0, 1, 2, 3, 4, 5 );
  }
}
