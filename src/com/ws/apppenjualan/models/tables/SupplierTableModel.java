/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.apppenjualan.models.tables;

import com.ws.apppenjualan.service.entity.SupplierEntity;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author WS
 */
public class SupplierTableModel extends AbstractTableModel {

    private List<SupplierEntity> list = new ArrayList<SupplierEntity>();

    public void setList(List<SupplierEntity> list) {
        this.list = list;
    }

    public boolean add(SupplierEntity e) {
        try {
            return list.add(e);
        } finally {
            fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
        }
    }

    public SupplierEntity get(int index) {
        return list.get(index);
    }

    public SupplierEntity set(int index, SupplierEntity element) {
        try {
            return list.set(index, element);
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    public SupplierEntity remove(int index) {
        try {
            return list.remove(index);
        } finally {
            fireTableRowsDeleted(index, index);
        }
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID Supplier";
            case 1:
                return "Nama Supplier";
            case 2:
                return "Alamat";
            case 3:
                return "Telephon";
            case 4:
                return "Email";
            case 5:
                return "Update";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getSupplier_id();
            case 1:
                return list.get(rowIndex).getSupplier_name();
            case 2:
                return list.get(rowIndex).getSupplier_address();
            case 3:
                return list.get(rowIndex).getSupplier_phone();
            case 4:
                return list.get(rowIndex).getSupplier_email();
            case 5:
                return list.get(rowIndex).getSupplier_lastmodif();
            default:
                return null;
        }
    }
}
