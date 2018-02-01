package com.mercateo.demo.functionaljava;

import io.vavr.control.Option;

import java.util.Optional;

public class OptionTest {


    public void testOption() {
        Option<String> string = Option.of("string");

        Optional<String> string1 = Optional.of("string");

        fj.data.Option<String> string2 = fj.data.Option.some("asfd");
    }
}
