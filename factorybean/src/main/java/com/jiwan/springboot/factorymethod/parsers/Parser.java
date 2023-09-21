package com.jiwan.springboot.factorymethod.parsers;

import java.io.Reader;
import java.util.List;

public interface Parser {
    List parse(Reader r);
    List parse(String stringPayload);
}
