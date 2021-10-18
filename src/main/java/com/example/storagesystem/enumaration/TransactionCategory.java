package com.example.storagesystem.enumaration;

public enum TransactionCategory {
    RECEIPTS("receiver"),
    DELIVERIES("deliverers");

    private String transactionCategory;

    TransactionCategory(String transactionCategory) {
        this.transactionCategory = transactionCategory;
    }

    public String getTransactionCategory() {return transactionCategory; }

    public static TransactionCategory[] getAll(){return  TransactionCategory.values();}
}
