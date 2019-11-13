package com.corejsf;

import com.model.Supplier;

public class EditableSupplier {

    private Supplier supplier;
    private boolean editable;
    
    public EditableSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }
    
    
}
