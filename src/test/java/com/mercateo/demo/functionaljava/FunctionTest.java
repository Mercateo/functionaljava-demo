package com.mercateo.demo.functionaljava;

import javaslang.Function1;
import javaslang.control.Option;
import org.junit.Test;

import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionTest {

    @Test
    public void testFunction() {
        String test = "Hello World!";

        int hashCode = test.hashCode();

        final Function1<Object, Integer> hash = Object::hashCode;
        assertThat(hash.apply(test)).isEqualTo(hashCode);

        final Function<Object, Integer> hashCache = Function1.of(Object::hashCode).memoized();
        assertThat(hashCache.apply(test)).isEqualTo(hashCode);
    }

    @Test
    public void testLift() {
        final Function1<Float, Float> partial = Function1.of(this::partial);

        final Function1<Float, Option<Float>> total = Function1.lift(partial);

        assertThat(total.apply(2.0f)).contains(0.5f);
        assertThat(total.apply(0f)).isEmpty();
    }

    private Float partial(Float x) {
        if (x > 0) {
            return 1 / x;
        } else {
            throw new IllegalStateException("invalid input");
        }
    }
}
