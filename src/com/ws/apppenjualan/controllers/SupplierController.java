/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.apppenjualan.controllers;

import com.ws.apppenjualan.models.SupplierModel;
import com.ws.apppenjualan.views.SupplierView;
import javax.swing.JOptionPane;

/**
 *
 * @author WS
 */
public class SupplierController {

    private SupplierModel model;

    public void setModel(SupplierModel model) {
        this.model = model;
    }

    public void resetForm(SupplierView view) {
        model.resetForm();
    }

    public void saveForm(SupplierView view) {
        String supplierName = view.getTextSupplierName().getText();
        String supplierAddress = view.getTextSupplierAddress().getText();
        String supplierPhone = view.getTextPhone().getText();
        String supplierEmail = view.getTextEmail().getText();

        model.setSupplierName(supplierName);
        model.setSupplierAddress(supplierAddress);
        model.setSupplierPhone(supplierPhone);
        model.setSupplierEmail(supplierEmail);

        if (supplierName.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama Harus Diisi!");
        } else {
            try {
                model.insertSupplier();
                JOptionPane.showMessageDialog(view, "Data Berhasil Disimpan.");
                model.resetForm();
            } catch (Throwable t) {
                JOptionPane.showMessageDialog(view, new Object[]{
                            "Terjadi kesalahan di database dengan pesan : ",
                            t.getMessage()
                        });
            }
        }
    }

    public void renderTableController(SupplierView view) {
        try {
            model.renderTableModel();
        } catch (Throwable t) {
            JOptionPane.showMessageDialog(view, new Object[]{
                        "Terjadi kesalahan di database dengan pesan : ",
                        t.getMessage()
                    });
        }
    }
}
