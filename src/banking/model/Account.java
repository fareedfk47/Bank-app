package banking.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String accountNumber;
    private final String customerID;
    private final String accountType;
    private BigDecimal balance;
    private final List<Transaction> transactions = new ArrayList<>();

    public Account(String accountNumber, String customerID, String accountType, BigDecimal initialBalance) {
        this.accountNumber = accountNumber;
        this.customerID = customerID;
        this.accountType = accountType;
        if (initialBalance != null && initialBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        this.balance = initialBalance != null ? initialBalance : BigDecimal.ZERO;
        if (this.balance.compareTo(BigDecimal.ZERO) > 0) {
            transactions.add(new Transaction("INITIAL_DEPOSIT", this.balance, this.balance));
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getAccountType() {
        return accountType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }

    public boolean deposit(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            return false;
        }
        balance = balance.add(amount);
        transactions.add(new Transaction("DEPOSIT", amount, balance));
        return true;
    }

    public boolean withdraw(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0 || amount.compareTo(balance) > 0) {
            return false;
        }
        balance = balance.subtract(amount);
        transactions.add(new Transaction("WITHDRAWAL", amount, balance));
        return true;
    }

    public boolean transfer(BigDecimal amount, Account recipient) {
        if (recipient == null || recipient == this) {
            return false;
        }
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0 || amount.compareTo(balance) > 0) {
            return false;
        }
        this.balance = this.balance.subtract(amount);
        recipient.balance = recipient.balance.add(amount);
        this.transactions.add(new Transaction("TRANSFER_TO " + recipient.accountNumber, amount, this.balance));
        recipient.transactions.add(new Transaction("TRANSFER_FROM " + this.accountNumber, amount, recipient.balance));
        return true;
    }
}
