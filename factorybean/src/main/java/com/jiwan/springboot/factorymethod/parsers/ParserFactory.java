package com.jiwan.springboot.factorymethod.parsers;

import com.jiwan.springboot.factorymethod.parsers.constants.ContentType;

public interface ParserFactory {
    Parser getParser(ContentType contentType);
}
