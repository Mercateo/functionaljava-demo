package com.mercateo.demo.functionaljava;

import fj.data.Either;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AlgebraicTypeTest {
    @Test
    public void testEither() {
        Either<String, Float> stringValue = Either.left("sert");

        assertThat(stringValue.isLeft()).isTrue();
        assertThat(stringValue.isRight()).isFalse();
    }
}
