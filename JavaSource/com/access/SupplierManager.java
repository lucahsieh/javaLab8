package com.access;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
import javax.sql.DataSource;

import com.model.Supplier;

@SessionScoped
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
                    ResultSet result = stmt.executeQuery("SELECT * FROM Suppliers ORDER BY SupplierID");
                    while(result.next()) {
                        suppliers.add(new Supplier(
                                result.getInt("SupplierID"),
                                result.getString("SupplierName"),
                                result.getString("ContactName"),
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
    
    public void remove(Supplier supplier) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            try {
                conn = ds.getConnection();
                try {
                    stmt = conn.prepareStatement("DELETE FROM Suppliers WHERE SupplierID = ? ORDER BY SupplierID");
                    stmt.setInt(1, supplier.getSupplierID());
                    stmt.executeUpdate();
                }finally {
                    if(stmt != null) {
                        stmt.close();
                    }
                }
                
            }finally {
                if(conn != null)
                    conn.close();
            }
            
        }catch(SQLException ex) {
            System.out.println("Error in remove" + supplier);
            ex.printStackTrace();
        }
    }
    
    public void update(Supplier supplier) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            try {
                conn = ds.getConnection();
                try {
                stmt = conn.prepareStatement(
                        "UPDATE Suppliers SET " +
                        "SupplierName = ?, " +
                        "ContactName = ?, " +
                        "ContactTitle = ?, " +
                        "Address = ?, " +
                        "City = ?, " +
                        "PostalCode = ?, " +
                        "StateOrProvince = ?, " +
                        "Country = ?, " +
                        "PhoneNumber = ?, " +
                        "FaxNumber = ?, " +
                        "PaymentTerms = ?, " +
                        "EmailAddress = ?, " +
                        "Notes = ? " +
                        "WHERE SupplierID = ?");
                stmt.setString(1,supplier.getSupplierName());
                stmt.setString(2,supplier.getContactName());
                stmt.setString(3,supplier.getContactTitle());
                stmt.setString(4,supplier.getAddress());
                stmt.setString(5,supplier.getCity());
                stmt.setString(6,supplier.getPostalCode());
                stmt.setString(7,supplier.getStateOrProvince());
                stmt.setString(8,supplier.getCountry());
                stmt.setString(9,supplier.getPhoneNumber());
                stmt.setString(10,supplier.getFaxNumber());
                stmt.setString(11,supplier.getPaymentTerms());
                stmt.setString(12,supplier.getEmailAddress());
                stmt.setString(13,supplier.getNotes());
                stmt.setInt(14, supplier.getSupplierID());
                stmt.executeUpdate();
                } finally {
                    if (stmt != null) {
                        stmt.close();
                    }
                }
            } finally {
                if(conn != null) {
                    conn.close();
                }
            }
            
        }catch(SQLException ex) {
            System.out.println("Error in update " + supplier);
            ex.printStackTrace();
        }
    }
    
    public void add(Supplier supplier) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            try {
                conn = ds.getConnection();
                try {
                stmt = conn.prepareStatement(
                        "INSERT INTO Suppliers VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )");
                stmt.setInt(1, supplier.getSupplierID());
                stmt.setString(2,supplier.getSupplierName());
                stmt.setString(3,supplier.getContactName());
                stmt.setString(4,supplier.getContactTitle());
                stmt.setString(5,supplier.getAddress());
                stmt.setString(6,supplier.getCity());
                stmt.setString(7,supplier.getPostalCode());
                stmt.setString(8,supplier.getStateOrProvince());
                stmt.setString(9,supplier.getCountry());
                stmt.setString(10,supplier.getPhoneNumber());
                stmt.setString(11,supplier.getFaxNumber());
                stmt.setString(12,supplier.getPaymentTerms());
                stmt.setString(13,supplier.getEmailAddress());
                stmt.setString(14,supplier.getNotes());
                stmt.executeUpdate();
                } finally {
                    if (stmt != null) {
                        stmt.close();
                    }
                }
            } finally {
                if(conn != null) {
                    conn.close();
                }
            }
            
        }catch(SQLException ex) {
            System.out.println("Error in update " + supplier);
            ex.printStackTrace();
        }
    }
}
