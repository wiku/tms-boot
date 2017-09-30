package com.wiku.tms.boot.model.assets;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee
{
    @Id @GeneratedValue
    private int id;
    private String name;
    private String surname;
    
}
