package banking.service;

import banking.model.Account;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankingService {
    private static final String DATA_FILE = "accounts.dat";
    private final List<Account> accounts;

    public BankingService() {
        this.accounts = loadAccounts();
    }

    public Account createAccount(String customerId, String accountType, BigDecimal initialDeposit) {
        String accNumber = String.format("ACC%03d", accounts.size() + 1);
        Account account = new Account(accNumber, customerId, accountType, initialDeposit);
        accounts.add(account);
        saveAccounts();
        return account;
    }

    public Account findAccount(String accountNumber) {
        if (accountNumber == null) {
            return null;
        }
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equalsIgnoreCase(accountNumber.trim())) {
                return acc;
            }
        }
        return null;
    }

    public boolean deposit(String accountNumber, BigDecimal amount) {
        Account account = findAccount(accountNumber);
        if (account != null && account.deposit(amount)) {
            saveAccounts();
            return true;
        }
        return false;
    }

    public boolean withdraw(String accountNumber, BigDecimal amount) {
        Account account = findAccount(accountNumber);
        if (account != null && account.withdraw(amount)) {
            saveAccounts();
            return true;
        }
        return false;
    }

    public boolean transfer(String senderAcc, String recipientAcc, BigDecimal amount) {
        Account sender = findAccount(senderAcc);
        Account recipient = findAccount(recipientAcc);
        if (sender != null && recipient != null && sender.transfer(amount, recipient)) {
            saveAccounts();
            return true;
        }
        return false;
    }

    public List<Account> getAllAccounts() {
        return Collections.unmodifiableList(accounts);
    }

    public int getAccountCount() {
        return accounts.size();
    }

    public void saveAccounts() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(new ArrayList<>(accounts));
        } catch (IOException e) {
            System.out.println("[!] Failed to save data: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private List<Account> loadAccounts() {
        File file = new File(DATA_FILE);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Account>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
