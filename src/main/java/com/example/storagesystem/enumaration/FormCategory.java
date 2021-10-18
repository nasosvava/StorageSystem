package com.example.storagesystem.enumaration;

public enum FormCategory {
    EXPORT_FORMS("Export Form"),
    IMPORT_FORMS("Import Form");

    private String formCategory;

    FormCategory(String formCategory) {
        this.formCategory = formCategory;
    }

    public String getFormCategory() {return formCategory;}

    public static FormCategory[] getAll(){
        return  FormCategory.values();
    }

}
