/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.apppenjualan.service.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author WS
 */
public class SupplierEntity implements Serializable {

    private String supplier_id;
    private String supplier_name;
    private String supplier_address;
    private String supplier_phone;
    private String supplier_email;
    private String supplier_lastmodif;

    public SupplierEntity() {
    }

    public SupplierEntity(String supplier_name, String supplier_address, String supplier_phone, String supplier_email, String supplier_lastmodif) {
        this.supplier_name = supplier_name;
        this.supplier_address = supplier_address;
        this.supplier_phone = supplier_phone;
        this.supplier_email = supplier_email;
        this.supplier_lastmodif = supplier_lastmodif;
    }

    public String getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(String supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public String getSupplier_address() {
        return supplier_address;
    }

    public void setSupplier_address(String supplier_address) {
        this.supplier_address = supplier_address;
    }

    public String getSupplier_phone() {
        return supplier_phone;
    }

    public void setSupplier_phone(String supplier_phone) {
        this.supplier_phone = supplier_phone;
    }

    public String getSupplier_email() {
        return supplier_email;
    }

    public void setSupplier_email(String supplier_email) {
        this.supplier_email = supplier_email;
    }

    public String getSupplier_lastmodif() {
        return supplier_lastmodif;
    }

    public void setSupplier_lastmodif(String supplier_lastmodif) {
        this.supplier_lastmodif = supplier_lastmodif;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.supplier_id);
        hash = 41 * hash + Objects.hashCode(this.supplier_name);
        hash = 41 * hash + Objects.hashCode(this.supplier_address);
        hash = 41 * hash + Objects.hashCode(this.supplier_phone);
        hash = 41 * hash + Objects.hashCode(this.supplier_email);
        hash = 41 * hash + Objects.hashCode(this.supplier_lastmodif);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SupplierEntity other = (SupplierEntity) obj;
        if (!Objects.equals(this.supplier_id, other.supplier_id)) {
            return false;
        }
        if (!Objects.equals(this.supplier_name, other.supplier_name)) {
            return false;
        }
        if (!Objects.equals(this.supplier_address, other.supplier_address)) {
            return false;
        }
        if (!Objects.equals(this.supplier_phone, other.supplier_phone)) {
            return false;
        }
        if (!Objects.equals(this.supplier_email, other.supplier_email)) {
            return false;
        }
        if (!Objects.equals(this.supplier_lastmodif, other.supplier_lastmodif)) {
            return false;
        }
        return true;
    }
}
