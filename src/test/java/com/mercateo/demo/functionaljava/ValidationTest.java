package com.mercateo.demo.functionaljava;

import fj.data.Validation;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationTest {

    @Test
    public void testValidation() {
        Validation<Exception, String> fail = Validation.fail(new IllegalStateException());
        Validation<Exception, String> success = Validation.success("yeah");

        assertThat(fail.isFail()).isTrue();
        assertThat(success.isSuccess()).isTrue();
    }

}
