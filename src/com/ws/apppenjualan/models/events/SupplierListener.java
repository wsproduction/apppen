/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.apppenjualan.models.events;

import com.ws.apppenjualan.models.SupplierModel;
import com.ws.apppenjualan.service.entity.SupplierEntity;

/**
 *
 * @author WS
 */
public interface SupplierListener {

    public void onChange(SupplierModel model);

    public void onInsert(SupplierEntity entity);

    public void onUpdate(SupplierEntity entity);

    public void onDelete();
}
