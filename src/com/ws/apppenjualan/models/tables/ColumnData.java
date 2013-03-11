/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.apppenjualan.models.tables;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author WS
 */
public class ColumnData {

    public String cdTitle;
    public int cdWidth;
    public DefaultTableCellRenderer cdAlignment;

    public ColumnData() {
    }

    public ColumnData(String cdTitle, int cdWidth, DefaultTableCellRenderer cdAlignment) {
        this.cdTitle = cdTitle;
        this.cdWidth = cdWidth;
        this.cdAlignment = cdAlignment;
    }

    public static DefaultTableCellRenderer setAlign(String align) {
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        switch (align) {
            case "LEFT":
                rightRenderer.setHorizontalAlignment(JLabel.LEFT);
                break;
            case "CENTER":
                rightRenderer.setHorizontalAlignment(JLabel.CENTER);
                break;
            case "RIGHT":
                rightRenderer.setHorizontalAlignment(JLabel.CENTER);
                break;
        }
        return rightRenderer;
    }
}
