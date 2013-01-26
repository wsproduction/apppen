/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.apppenjualan.service.error;

/**
 *
 * @author WS
 */
public class SupplierException extends Exception {

    /**
     * Creates a new instance of
     * <code>SupplierException</code> without detail message.
     */
    public SupplierException() {
    }

    /**
     * Constructs an instance of
     * <code>SupplierException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public SupplierException(String msg) {
        super(msg);
    }
}
