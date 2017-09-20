package com.wiku.tms.boot.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wiku.tms.boot.model.assets.Asset;
import com.wiku.tms.boot.repository.AssetRepository;

@RestController
@RequestMapping("api/v1")
public class AssetController
{
    @Autowired
    private AssetRepository repository;

    @RequestMapping(value = "assets", method = RequestMethod.GET)
    public List<Asset> getAll()
    {
        return repository.findAll();
    }

    @RequestMapping(value = "assets/{id}", method = RequestMethod.GET)
    public Asset get(@PathVariable Integer id) throws ResourceNotFoundException
    {
        Asset asset = repository.findOne(id);
     
        if (asset == null)
            throw new ResourceNotFoundException(String.format("Asset id=%d does not exist", id));
        
        return asset;
    }

    @RequestMapping(value = "assets", method = RequestMethod.POST)
    public Asset create(@RequestBody Asset asset)
    {
        return repository.saveAndFlush(asset);
    }

    @RequestMapping(value = "assets/{id}", method = RequestMethod.PUT)
    public Asset update(@PathVariable Integer id, @RequestBody Asset asset) throws ResourceNotFoundException
    {
        Asset assetToUpdate = repository.findOne(id);
        
        if (assetToUpdate == null)
            throw new ResourceNotFoundException(String.format("Asset id=%d does not exist", id));

        BeanUtils.copyProperties(asset, assetToUpdate);
        return repository.saveAndFlush(assetToUpdate);
    }

    @RequestMapping(value = "assets/{id}", method = RequestMethod.DELETE)
    public Asset delete(@PathVariable Integer id) throws ResourceNotFoundException
    {
        Asset assetToDelete = repository.findOne(id);
        
        if (assetToDelete == null)
            throw new ResourceNotFoundException(String.format("Asset with id=%d does not exist", id));
        
        repository.delete(id);
        return assetToDelete;
    }

}
