package com.wiku.tms.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wiku.tms.boot.model.Asset;

public interface AssetRepository extends JpaRepository<Asset, Integer>
{
    
}
