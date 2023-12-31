package com.jiwan.springboot.factorymethod.parsers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jiwan.springboot.factorymethod.avengers.domain.Avenger;
import com.jiwan.springboot.factorymethod.avengers.domain.exception.ParserIOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

@Component(TypedConstants.JSON_PARSER)
@Slf4j
public class JSONParser implements Parser {

    private static ObjectMapper _cached;

    static {
        _cached = new ObjectMapper();
    }

    @Override
    public List<Avenger> parse(Reader r) {
        try {
            return _cached.readValue(r, new TypeReference<List<Avenger>>() {
            });

        } catch (IOException e) {
            throw new ParserIOException("Io error while parsing JSON file", e);
        }
    }

    @Override
    public List<Avenger> parse(String payload) {
        try {
            return _cached.readValue(payload, new TypeReference<List<Avenger>>() {
            });

        } catch (IOException e) {
            throw new ParserIOException("Io error while parsing JSON file", e);
        }
    }
}
