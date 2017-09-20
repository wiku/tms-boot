package com.wiku.tms.boot.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.wiku.tms.boot.model.assets.Asset;
import com.wiku.tms.boot.repository.AssetRepository;

public class AssetControllerTest
{
    private static final Asset TOOL_1 = new Asset(1, "hammer", "tools", 10, 1000, "H1-10");
    private static final Asset TOOL_2 = new Asset(2, "hammer", "tools", 5, 3000, "H2-10");
    private static final Asset TOOL_3 = new Asset(3, "screwdriver", "tools", 4, 2000, "S1-10");
    private static final Asset TOOL_3_NEW_ID = new Asset(103, "screwdriver", "tools", 4, 2000, "S1-10");
    private static final Asset TOOL_3_MODIFIED = new Asset(3, "screwdriver x", "tools", 5, 2000, "S1-10");
    
    private static final List<Asset> ALL_ASSETS = Arrays.asList(TOOL_1, TOOL_2, TOOL_3);
    
    @Mock
    private AssetRepository repository;

    @InjectMocks
    AssetController assetsController;

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void canGetAllAssets()
    {
        when(repository.findAll()).thenReturn(ALL_ASSETS);
        assertEquals(ALL_ASSETS, assetsController.getAll());
    }

    @Test
    public void canGetAssetsById() throws ResourceNotFoundException
    {
        when(repository.findOne(TOOL_1.getId())).thenReturn(TOOL_1);
        when(repository.findOne(TOOL_2.getId())).thenReturn(TOOL_2);
        assertEquals(TOOL_1, assetsController.get(TOOL_1.getId()));
        assertEquals(TOOL_2, assetsController.get(TOOL_2.getId()));
    }

    @Test(expected = ResourceNotFoundException.class)
    public void throwsExceptionFromGetWhenAssetDoesNotExist() throws ResourceNotFoundException
    {
        assetsController.get(TOOL_1.getId());
    }

    @Test
    public void canCrateNewAssets()
    {
        when(repository.saveAndFlush((TOOL_3))).thenReturn(TOOL_3_NEW_ID);
        assertEquals(TOOL_3_NEW_ID, assetsController.create(TOOL_3));
    }

    @Test
    public void canUpdateAssets() throws ResourceNotFoundException
    {
        when(repository.findOne(TOOL_3.getId())).thenReturn(TOOL_3);
        when(repository.saveAndFlush(TOOL_3_MODIFIED)).thenReturn(TOOL_3_MODIFIED);
        assertEquals(TOOL_3_MODIFIED, assetsController.update(TOOL_3.getId(), TOOL_3_MODIFIED));
    }

    @Test(expected = ResourceNotFoundException.class)
    public void throwsExceptionWhenTryToUpdateNonExistingAsset() throws ResourceNotFoundException
    {
        assetsController.update(TOOL_3.getId(), TOOL_3_MODIFIED);
    }

    @Test
    public void canDeleteAsset() throws ResourceNotFoundException
    {
        when(repository.findOne(TOOL_1.getId())).thenReturn(TOOL_1);
        assertEquals(TOOL_1, assetsController.delete(TOOL_1.getId()));
        verify(repository).delete(TOOL_1.getId());
    }
    
    @Test(expected = ResourceNotFoundException.class)
    public void throwsExceptionWhenTryToDeleteNonExistingAsset() throws ResourceNotFoundException
    {
        assetsController.delete(TOOL_3.getId());
    }
}
