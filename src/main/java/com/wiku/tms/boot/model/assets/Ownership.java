package com.wiku.tms.boot.model.assets;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ownership
{

    
    @Id @GeneratedValue
    private int id;
    
    @OneToOne
    private Employee employee;
    
    @OneToOne
    private Asset asset;
    
    private int amount;
}
