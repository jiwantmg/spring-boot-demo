package com.jiwan.springboot.factorymethod.avengers.controller;

import com.jiwan.springboot.factorymethod.avengers.domain.Avenger;
import com.jiwan.springboot.factorymethod.avengers.service.AvengersService;
import com.jiwan.springboot.factorymethod.parsers.constants.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/avengers", produces = MediaType.APPLICATION_JSON_VALUE)
public class AvengersController {

    private AvengersService service;

    @Autowired
    public AvengersController(AvengersService service) {
        this.service = service;
    }

    @GetMapping("/csv")
    public ResponseEntity<List<Avenger>> getAllFromCsv() {
        return ResponseEntity.ok().body(service.getAll(ContentType.CSV));
    }

    @GetMapping("/json")
    public ResponseEntity<List<Avenger>> getAllFromJson() {
        return ResponseEntity.ok().body(service.getAll(ContentType.JSON));
    }

    @GetMapping("/xml")
    public ResponseEntity<List<Avenger>> getAllFromXml() {
        return ResponseEntity.ok().body(service.getAll(ContentType.XML));
    }
}