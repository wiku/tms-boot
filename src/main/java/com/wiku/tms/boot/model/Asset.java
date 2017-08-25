package com.wiku.tms.boot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Asset
{

    @Id @GeneratedValue
    private int id;
    private String name;
    private String type;
    private int amount;
    private int worth;
    private String identifier;

}
