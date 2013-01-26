/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.apppenjualan.config;

/**
 *
 * @author WS
 */
public class PrimaryIdGenerator {

    private String format;
    private String prefix;
    private String entity_name;
    private String table_name;

    public PrimaryIdGenerator() {
    }

    public PrimaryIdGenerator(String format, String prefix, String entity_name, String table_name) {
        this.format = format;
        this.prefix = prefix;
        this.entity_name = entity_name;
        this.table_name = table_name;
    }

    public void setReferences(String table_name, String entity_name) {
        this.entity_name = entity_name;
        this.table_name = table_name;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getEntity_name() {
        return entity_name;
    }

    public void setEntity_name(String entity_name) {
        this.entity_name = entity_name;
    }

    public String getTable_name() {
        return table_name;
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }

    public String generateId() {
        String query = null;
        if (getFormat().equals("date")) {
            query = "(SELECT IF ( "
                    + "   (SELECT COUNT(a." + getEntity_name() + ") FROM " + getTable_name() + " AS a "
                    + "         WHERE a." + getEntity_name() + " LIKE (SELECT CONCAT(DATE_FORMAT(CURDATE(),'" + getPrefix() + "%y%m%d'),'%')) "
                    + "         ORDER BY a." + getEntity_name() + " DESC LIMIT 1 "
                    + "    ) > 0,"
                    + "   (SELECT CONCAT('" + getPrefix() + "', RIGHT(a." + getEntity_name() + ", 9) + 1 ) FROM " + getTable_name() + " AS a "
                    + "           WHERE a." + getEntity_name() + " LIKE (SELECT CONCAT(DATE_FORMAT(CURDATE(),'" + getPrefix() + "%y%m%d'),'%')) "
                    + "           ORDER BY a." + getEntity_name() + " DESC LIMIT 1), "
                    + "   (SELECT DATE_FORMAT(CURDATE(),'" + getPrefix() + "%y%m%d001'))) AS b)";
        }
        return query;
    }
}
