package com.jiwan.springboot.factorymethod.avengers.service;

import com.jiwan.springboot.factorymethod.avengers.domain.Avenger;
import com.jiwan.springboot.factorymethod.parsers.constants.ContentType;

import java.util.List;

public interface AvengersService {

    List<Avenger> getAll(ContentType contentType);
}
