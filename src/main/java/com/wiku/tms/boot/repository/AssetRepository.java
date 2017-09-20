package com.wiku.tms.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wiku.tms.boot.model.assets.Asset;

public interface AssetRepository extends JpaRepository<Asset, Integer>
{
    
}
