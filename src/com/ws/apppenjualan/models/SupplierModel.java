/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.apppenjualan.models;

import com.ws.apppenjualan.models.events.SupplierListener;
import com.ws.apppenjualan.service.SupplierDao;
import com.ws.apppenjualan.service.entity.SupplierEntity;
import com.ws.apppenjualan.service.error.SupplierException;
import com.ws.apppenjualan.service.injection.SupplierInjection;
import java.util.List;

/**
 *
 * @author WS
 */
public class SupplierModel {

    private String supplierName;
    private String supplierAddress;
    private String supplierPhone;
    private String supplierEmail;
    private SupplierListener supplierListener;
    private SupplierEntity supplier;

    public SupplierListener getSupplierListener() {
        return supplierListener;
    }

    public void setSupplierListener(SupplierListener supplierListener) {
        this.supplierListener = supplierListener;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
        fireOnChange();
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
        fireOnChange();
    }

    public String getSupplierPhone() {
        return supplierPhone;
    }

    public void setSupplierPhone(String supplierPhone) {
        this.supplierPhone = supplierPhone;
        fireOnChange();
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
        fireOnChange();
    }

    protected void fireOnChange() {
        if (supplierListener != null) {
            supplierListener.onChange(this);
        }
    }

    protected void fireOnInsert(SupplierEntity entity) {
        if (supplierListener != null) {
            supplierListener.onInsert(entity);
        }
    }

    protected void fireOnUpdate(SupplierEntity entity) {
        if (supplierListener != null) {
            supplierListener.onUpdate(entity);
        }
    }

    protected void fireOnDelete() {
        if (supplierListener != null) {
            supplierListener.onDelete();
        }
    }

    protected void fireOnActived(List<SupplierEntity> list) {
        if (supplierListener != null) {
            supplierListener.onActived(list);
        }
    }

    public void resetForm() {
        setSupplierName("");
        setSupplierAddress("");
        setSupplierPhone("");
        setSupplierEmail("");
    }

    public void insertSupplier() throws SupplierException {

        SupplierEntity entity = new SupplierEntity();
        entity.setSupplier_name(supplierName);
        entity.setSupplier_address(supplierAddress);
        entity.setSupplier_phone(supplierPhone);
        entity.setSupplier_email(supplierEmail);

        SupplierDao dao = new SupplierInjection();
        dao.insertSupplier(entity);
        
        fireOnInsert(entity);
    }

    public void renderTableModel() throws SupplierException {
        SupplierDao dao = new SupplierInjection();
        fireOnActived(dao.findAllSupplier());
    }
}
