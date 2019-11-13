package com.access;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.sql.DataSource;

import com.model.Supplier;

public class SupplierManager implements Serializable{
    private static final long serialVersionUID =1L;
    
    @Resource(mappedName = "java:jboss/datasources/inventory")
    private DataSource ds;
    
    public Supplier[] getAll() {
        ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
        Connection conn = null;
        Statement stmt = null;
        try {
            try {
                conn = ds.getConnection();
                try {
                    stmt = conn.createStatement();
                    ResultSet result = stmt.executeQuery("SELECT * FROM Supplier ORDER BY SupplierID");
                    while(result.next()) {
                        suppliers.add(new Supplier(
                                result.getInt("SupplierID"),
                                result.getString("SupplierName"),
                                result.getString("ContactTitle"),
                                result.getString("Address"),
                                result.getString("City"),
                                result.getString("PostalCode"),
                                result.getString("StateOrProvince"),
                                result.getString("Country"),
                                result.getString("PhoneNumber"),
                                result.getString("FaxNumber"),
                                result.getString("PaymentTerms"),
                                result.getString("EmailAddress"),
                                result.getString("Notes")
                                ));
                    }
                    
                }finally {
                    if(stmt != null) {
                        stmt.close();
                    }
                }
            } finally {
                if(conn != null) {
                    conn.close();
                }
            }
            
        }catch(SQLException ex) {
            System.out.println("Error in getALL");
            ex.printStackTrace();
            return null;
        }
        Supplier[] supplierArr = new Supplier[suppliers.size()];
        return suppliers.toArray(supplierArr);
        
    }
}
