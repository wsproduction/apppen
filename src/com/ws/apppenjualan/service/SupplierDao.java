/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.apppenjualan.service;

import com.ws.apppenjualan.service.entity.SupplierEntity;
import com.ws.apppenjualan.service.error.SupplierException;
import java.util.List;

/**
 *
 * @author WS
 */
public interface SupplierDao {

    public void insertSupplier(SupplierEntity entity) throws SupplierException;

    public void updateSupplier(SupplierEntity entity) throws SupplierException;

    public void deleteSupplier(String id) throws SupplierException;
    
    public void getSupplier(String id) throws SupplierException;

    public List<SupplierEntity> findAllSupplier() throws SupplierException;
}
