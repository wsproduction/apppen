/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.apppenjualan.service.injection;

import com.ws.apppenjualan.config.ConnectionFactory;
import com.ws.apppenjualan.config.PrimaryIdGenerator;
import com.ws.apppenjualan.service.SupplierDao;
import com.ws.apppenjualan.service.entity.SupplierEntity;
import com.ws.apppenjualan.service.error.SupplierException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WS
 */
public class SupplierInjection implements SupplierDao {

    private Connection conn = null;
    private PreparedStatement sth = null;
    private ResultSet res = null;

    public SupplierInjection() {
    }

    private Connection getConnection() throws SQLException {
        Connection con;
        con = ConnectionFactory.getInstance().getConnection();
        return con;
    }

    @Override
    public void insertSupplier(SupplierEntity entity) throws SupplierException {
        try {
            PrimaryIdGenerator pig = new PrimaryIdGenerator();
            pig.setFormat("date");
            pig.setPrefix("SUP");
            pig.setReferences("supplier", "supplier_id");
            String id = pig.generateId();

            String query;
            query = "INSERT INTO "
                    + "supplier( "
                    + "supplier_id, "
                    + "supplier_name, "
                    + "supplier_address, "
                    + "supplier_phone, "
                    + "supplier_email, "
                    + "supplier_lastmodif) "
                    + "VALUES( "
                    + id
                    + ",?,?,?,?,NOW()); ";

            conn = getConnection();
            conn.setAutoCommit(false);
            sth = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            sth.setString(1, entity.getSupplier_name());
            sth.setString(2, entity.getSupplier_address());
            sth.setString(3, entity.getSupplier_phone());
            sth.setString(4, entity.getSupplier_email());
            sth.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
            }
            throw new SupplierException(e.getMessage());
        } finally {
            try {
                if (sth != null) {
                    sth.close();
                }
                if (conn != null) {
                    conn.setAutoCommit(false);
                    conn.close();
                }
            } catch (SQLException e) {
            } catch (Exception e) {
            }
        }
    }

    @Override
    public void updateSupplier(SupplierEntity entity) throws SupplierException {
    }

    @Override
    public void deleteSupplier(String id) throws SupplierException {
    }

    @Override
    public void getSupplier(String id) throws SupplierException {
    }

    @Override
    public List<SupplierEntity> findAllSupplier() throws SupplierException {
        String query;
        List<SupplierEntity> list = new ArrayList<SupplierEntity>();
        try {
            query = " SELECT * FROM supplier";
            conn = getConnection();
            sth = conn.prepareStatement(query);
            res = sth.executeQuery();
            while (res.next()) {
                SupplierEntity entity = new SupplierEntity();
                entity.setSupplier_id(res.getString("supplier_id"));
                entity.setSupplier_name(res.getString("supplier_name"));
                entity.setSupplier_address(res.getString("supplier_address"));
                entity.setSupplier_phone(res.getString("supplier_phone"));
                entity.setSupplier_email(res.getString("supplier_email"));
                entity.setSupplier_lastmodif(res.getString("supplier_lastmodif"));
                list.add(entity);
            }
            return list;
        } catch (SQLException e) {
            throw new SupplierException(e.getMessage());
        } finally {
            try {
                if (sth != null) {
                    sth.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
            } catch (Exception e) {
            }
        }
    }
}
