package com.jiwan.springboot.factorymethod.avengers.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Avenger {

    private String name;
    private String gender;
    private Integer doj;
    private String notes;
}