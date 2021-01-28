package models;

import java.util.List;

public class Transaction {
    private String idTransaction;
    private String dateTransaction;
    private Integer grandtotal;
    private List<TransactionDetails> transactionDetails;

    public Transaction(String idTransaction, String dateTransaction, Integer grandtotal, List<TransactionDetails> transactionDetails) {
        this.idTransaction = idTransaction;
        this.dateTransaction = dateTransaction;
        this.grandtotal = grandtotal;
        this.transactionDetails = transactionDetails;
    }

    public String getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(String idTransaction) {
        this.idTransaction = idTransaction;
    }

    public String getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(String dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public Integer getGrandtotal() {
        return grandtotal;
    }

    public void setGrandtotal(Integer grandtotal) {
        this.grandtotal = grandtotal;
    }

    public List<TransactionDetails> getTransactionDetails() {
        return transactionDetails;
    }

    public void setTransactionDetails(List<TransactionDetails> transactionDetails) {
        this.transactionDetails = transactionDetails;
    }
}
