package com.wiku.tms.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wiku.tms.boot.model.assets.Asset;
import com.wiku.tms.boot.model.assets.Employee;
import com.wiku.tms.boot.model.assets.Ownership;

public interface OwnershipRepository extends JpaRepository<Ownership, Integer>
{
    
    public List<Ownership> findByEmployee(Employee employee);
    public List<Ownership> findByAsset(Asset asset);
}
