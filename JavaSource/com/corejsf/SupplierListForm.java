package com.corejsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.access.SupplierManager;
import com.model.Supplier;

@Named
@SessionScoped
public class SupplierListForm implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Inject
    private SupplierManager supplierManager;
    
    @Inject
    private Conversation conversation;
    
    private String keyword = "";
    
    List<EditableSupplier> list;
    
    private void refreshList() {
        Supplier[] suppliers = supplierManager.searchByName(keyword);
        list = new ArrayList<EditableSupplier>();
        for(int i = 0; i < suppliers.length; i++) {
            list.add(new EditableSupplier(suppliers[i]));
        }
    }
    
    public List<EditableSupplier> getList(){
        if(list == null)
            refreshList();
        return list;
        
    }
    
    public void setList(List<EditableSupplier>es) {
        list = es;
    }
    
    public String getKeyword() {
        if (keyword == null)
            keyword = "";
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String deleteRow(EditableSupplier es) {
        supplierManager.remove(es.getSupplier());
        list.remove(es);
        return null;
    }
    
    public String search() {
        refreshList();
        return null;
    }
    
    public String save() {
        for(EditableSupplier es : list) {
            if(es.isEditable()) {
                supplierManager.update(es.getSupplier());
                es.setEditable(false);
            }
        }
        return null;
    }
    
    public String back() {
        keyword = "";
        list = null;
        return "index";
    }
    
    
    

}
