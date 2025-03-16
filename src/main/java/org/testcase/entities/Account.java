package org.testcase.entities;

import java.util.Map;

public class Account {

    private int billNumber;
    private String owner;
    private Map<String,Double> balance;

    @Override
    public String toString() {            //не работает(((
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Double> entry: balance.entrySet()){
            builder.append(entry.getValue()).append(" ").append(entry.getValue()).append("    ");
        }
        return builder.toString();
    }

    public Account(int billNumber, String owner, Map<String, Double> amount) {
        this.billNumber = billNumber;
        this.owner = owner;
        this.balance = amount;
    }

    public int getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(int billNumber) {
        this.billNumber = billNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Map<String, Double> getBalance() {
        return balance;
    }

}
