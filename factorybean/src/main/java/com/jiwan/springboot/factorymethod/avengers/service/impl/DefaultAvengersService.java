package com.jiwan.springboot.factorymethod.avengers.service.impl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.jiwan.springboot.factorymethod.avengers.domain.Avenger;
import com.jiwan.springboot.factorymethod.avengers.service.AvengersService;
import com.jiwan.springboot.factorymethod.parsers.ParserFactory;
import com.jiwan.springboot.factorymethod.parsers.constants.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DefaultAvengersService implements AvengersService {

    private ParserFactory parserFactory;

    @Autowired
    public DefaultAvengersService(ParserFactory parserFactory) {
        this.parserFactory = parserFactory;
    }

    @Override
    public List<Avenger> getAll(ContentType contentType) {
        String fileName = contentType.fileName();
        log.info("Fetching list from file {}", fileName);

        return parserFactory
                .getParser(contentType)
                .parse(getFileHandle(fileName));
    }

    private Reader getFileHandle(String fileName) {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(fileName);
        return new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
    }
}
