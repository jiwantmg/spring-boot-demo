package com.jiwan.springboot.factorymethod.parsers.constants;

import com.jiwan.springboot.factorymethod.parsers.TypedConstants;

public enum ContentType {
    JSON(TypedConstants.JSON_PARSER) {
        @Override
        public String fileName() {
            return "avengers.json";
        }
    },
    CSV(TypedConstants.CSV_PARSER) {
        @Override
        public String fileName() {
            return "avengers.csv";
        }
    },
    XML(TypedConstants.XML_PARSER) {
        @Override
        public String fileName() {
            return "avengers.xml";
        }
    };

    public abstract String fileName();

    private final String parserName;
    ContentType(String parserName) {
        this.parserName = parserName;
    }

    @Override
    public String toString() {
       return this.parserName;
    }
}

