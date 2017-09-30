package com.wiku.tms.boot;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wiku.tms.boot.model.assets.Asset;
import com.wiku.tms.boot.model.assets.Employee;
import com.wiku.tms.boot.model.assets.Ownership;
import com.wiku.tms.boot.repository.AssetRepository;
import com.wiku.tms.boot.repository.EmployeeRepository;
import com.wiku.tms.boot.repository.OwnershipRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TmsBootApplicationTests
{


    @Autowired
    EmployeeRepository employees;

    @Autowired
    AssetRepository assets;

    @Autowired
    OwnershipRepository ownerships;

    @Before
    public void setup()
    {
        ownerships.deleteAll();
        assets.deleteAll();
        employees.deleteAll();
    }

    @Test
    public void canCreateTestDatabase()
    {

        Asset asset = new Asset(1, "wiertarka udarowa", "wiertarka", 5, 200000, "WU-1");
        asset = assets.saveAndFlush(asset);

        Employee employee = new Employee(1, "Wojciech", "Migdał");
        employee = employees.saveAndFlush(employee);

        Ownership ownership = new Ownership(1, employee, asset, 1);
        ownership = ownerships.saveAndFlush(ownership);

        assertThat(ownerships.findByAsset(asset).contains(asset));
        assertThat(ownerships.findByEmployee(employee).contains(asset));
    }

}
