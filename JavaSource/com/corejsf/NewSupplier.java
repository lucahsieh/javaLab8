package com.corejsf;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.access.SupplierManager;
import com.model.Supplier;

@Named
@SessionScoped
public class NewSupplier implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Inject
    private SupplierManager supplierManager;
    
    private Supplier supplier;
    
    public NewSupplier() {}

    public SupplierManager getSupplierManager() {
        return supplierManager;
    }

    public void setSupplierManager(SupplierManager supplierManager) {
        this.supplierManager = supplierManager;
    }

    public Supplier getSupplier() {
        if(supplier == null)
            supplier = new Supplier();
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    
    public String back() {
        supplier = new Supplier();
        return "index";
    }
    
    public String submit() {
        supplierManager.add(supplier);
        supplier = new Supplier();
        return "index";
    }
    
    

}
