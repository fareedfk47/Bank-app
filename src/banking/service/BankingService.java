package banking.service;

import banking.model.Account;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankingService {
    private static final String DEFAULT_DATA_FILE = "accounts.dat";
    private final String dataFile;
    private final List<Account> accounts;

    public BankingService() {
        this(DEFAULT_DATA_FILE);
    }

    public BankingService(String dataFile) {
        this.dataFile = dataFile;
        this.accounts = loadAccounts();
    }

    public Account createAccount(String customerId, String accountType, BigDecimal initialDeposit) {
        if (initialDeposit != null && initialDeposit.compareTo(BigDecimal.ZERO) < 0) {
            System.err.println("[!] WARNING: Initial deposit cannot be negative.");
            return null;
        }
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

    public boolean saveAccounts() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dataFile))) {
            oos.writeObject(new ArrayList<>(accounts));
            return true;
        } catch (IOException e) {
            System.err.println("[!] WARNING: Could not save account data to '" + dataFile + "': " + e.getMessage());
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    private List<Account> loadAccounts() {
        File file = new File(dataFile);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            List<Account> loaded = (List<Account>) ois.readObject();
            if (loaded == null) {
                System.err.println("[!] WARNING: Data file '" + dataFile + "' is empty or invalid.");
                return new ArrayList<>();
            }
            return loaded;
        } catch (Exception e) {
            System.err.println("[!] WARNING: Failed to load account data from '" + dataFile + "': " + e.getMessage());
            System.err.println("[!] WARNING: Continuing with empty accounts to avoid overwriting invalid data.");
            return new ArrayList<>();
        }
    }
}
