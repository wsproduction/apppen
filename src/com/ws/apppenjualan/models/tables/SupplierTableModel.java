/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.apppenjualan.models.tables;

import com.ws.apppenjualan.service.entity.SupplierEntity;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author WS
 */
public class SupplierTableModel extends AbstractTableModel {

    private List<SupplierEntity> list = new ArrayList<SupplierEntity>();
    private ColumnData columns[] = {
        new ColumnData("ID Supplier", 100, ColumnData.setAlign("CENTER")),
        new ColumnData("Nama Supplier", 200, ColumnData.setAlign("LEFT")),
        new ColumnData("Alamat", 200, ColumnData.setAlign("LEFT")),
        new ColumnData("Telephon", 200, ColumnData.setAlign("LEFT")),
        new ColumnData("Email", 200, ColumnData.setAlign("LEFT")),
        new ColumnData("Update", 200, ColumnData.setAlign("LEFT"))
    };

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
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        if (column >= 0 && column < getColumnCount()) {
            return columns[column].cdTitle;
        } else {
            return null;
        }
    }

    public int getColumnWidth(int column) {
        if (column >= 0 && column < getColumnCount()) {
            return columns[column].cdWidth;
        } else {
            return 0;
        }
    }

    public DefaultTableCellRenderer getColumnAlignment(int column) {
        if (column >= 0 && column < getColumnCount()) {
            return columns[column].cdAlignment;
        } else {
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
