package com.jiwan.springboot.factorymethod.parsers;

import com.jiwan.springboot.factorymethod.parsers.constants.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParserService {
    private ParserFactory parserFactory;

    @Autowired
    public ParserService(
            ParserFactory parserFactory
    ) {
        this.parserFactory = parserFactory;
    }

    public List getAll(ContentType contentType) {
        return parserFactory.getParser(contentType).parse("");
    }

}
