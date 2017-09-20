package com.wiku.tms.boot.model.assets;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Ownership
{

    @Id @GeneratedValue
    private int id;
    
    private Employee employee;
    private Asset asset;
    private int amount;
}
