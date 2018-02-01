package com.mercateo.demo.functionaljava;

import io.vavr.Function1;
import io.vavr.Function2;
import io.vavr.Function3;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PartialFunctionsTest {

    @Test
    public void testApplyJavaSlang() {
        Function3<Float, Float, Float, Float> calculate = getFunction();

        Function2<Float, Float, Float> calculate2 = calculate.apply(5.0f);

        Function1<Float, Float> calculate3 = calculate2.apply(2.0f);

        assertThat(calculate3.apply(10.0f)).isEqualTo(20.0f);
    }

    @Test
    public void testCurriedJavaSlang() {
        Function3<Float, Float, Float, Float> calculate = getFunction();

        Function1<Float, Function1<Float, Function1<Float, Float>>> curried = calculate.curried();

        Function1<Float, Function1<Float, Float>> curried2 = curried.apply(5.0f);

        Function1<Float, Float> curried3 = curried2.apply(2.0f);

        assertThat(curried3.apply(10.0f)).isEqualTo(20.0f);
    }

    private Function3<Float, Float, Float, Float> getFunction() {
        return (x, y, z) -> x * y + z;
    }

}
