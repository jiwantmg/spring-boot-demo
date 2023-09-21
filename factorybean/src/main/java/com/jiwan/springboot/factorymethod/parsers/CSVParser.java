package com.jiwan.springboot.factorymethod.parsers;

import com.jiwan.springboot.factorymethod.avengers.domain.Avenger;
import com.jiwan.springboot.factorymethod.avengers.domain.exception.ParserIOException;
import lombok.extern.slf4j.Slf4j;
import org.simpleflatmapper.csv.CsvParser;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.stream.Collectors;

@Component(TypedConstants.CSV_PARSER)
@Slf4j
public class CSVParser implements Parser {

    private static CsvParser.MapToDSL _cached;

    static {
        _cached = CsvParser
                .separator(',')
                .trimSpaces()
                .mapTo(Avenger.class);
    }

    @Override
    public List<Avenger> parse(Reader r) {
        try {
            return (List<Avenger>) _cached.stream(r).collect(Collectors.toList());

        } catch (IOException e) {
            throw new ParserIOException("Io error while parsing CSV file", e);
        }
    }

    @Override
    public List<Avenger> parse(String payload) {
        try {
            return (List<Avenger>) _cached.stream(payload).collect(Collectors.toList());

        } catch (IOException e) {
            throw new ParserIOException("Io error while parsing CSV file", e);
        }
    }
}
