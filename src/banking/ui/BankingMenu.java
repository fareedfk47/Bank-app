package banking.ui;

import banking.model.Account;
import banking.model.Transaction;
import banking.service.BankingService;

import java.math.BigDecimal;
import java.util.Scanner;

public class BankingMenu {
    private final BankingService service;
    private final Scanner scanner;

    public BankingMenu(BankingService service, Scanner scanner) {
        this.service = service;
        this.scanner = scanner;
    }

    public void start() {
        boolean running = true;
        System.out.println("==================================================");
        System.out.println("          CONSOLE BANKING APPLICATION             ");
        System.out.println("==================================================");

        while (running) {
            System.out.println("\n----------------- MAIN MENU ------------------");
            System.out.println(" [1] Create New Account");
            System.out.println(" [2] Deposit Money");
            System.out.println(" [3] Withdraw Money");
            System.out.println(" [4] Transfer Money");
            System.out.println(" [5] View Account Statement");
            System.out.println(" [6] List All Accounts");
            System.out.println(" [7] Search Account");
            System.out.println(" [0] Exit Application");
            System.out.println("----------------------------------------------");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    createAccount();
                    break;
                case "2":
                    depositMoney();
                    break;
                case "3":
                    withdrawMoney();
                    break;
                case "4":
                    transferMoney();
                    break;
                case "5":
                    showStatement();
                    break;
                case "6":
                    listAccounts();
                    break;
                case "7":
                    searchAccount();
                    break;
                case "0":
                    if (service.saveAccounts()) {
                        System.out.println("\n[✓] Data saved successfully. Goodbye!");
                    } else {
                        System.out.println("\n[!] WARNING: Changes could not be saved to disk!");
                    }
                    running = false;
                    break;
                default:
                    System.out.println("[!] Invalid option. Please enter a valid number (0-7).");
                    break;
            }
        }
    }

    private void createAccount() {
        System.out.println("\n--- Create New Account ---");
        System.out.print("Enter Customer ID/Name: ");
        String customerId = scanner.nextLine().trim();
        if (customerId.isEmpty()) {
            customerId = "CUST" + String.format("%03d", service.getAccountCount() + 1);
        }

        System.out.print("Enter Account Type (SAVINGS/CURRENT) [Default: SAVINGS]: ");
        String type = scanner.nextLine().trim().toUpperCase();
        if (type.isEmpty()) {
            type = "SAVINGS";
        }

        System.out.print("Enter Initial Deposit (or 0): ");
        BigDecimal initial = parseAmount(scanner.nextLine().trim());
        if (initial == null || initial.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("[!] Invalid initial deposit. Account creation cancelled.");
            return;
        }

        Account account = service.createAccount(customerId, type, initial);
        System.out.println("\n[✓] Account created successfully!");
        printAccountCard(account);
    }

    private void depositMoney() {
        System.out.println("\n--- Deposit Money ---");
        System.out.print("Enter Account Number: ");
        String accNum = scanner.nextLine().trim();
        System.out.print("Enter Amount to Deposit: ");
        BigDecimal amount = parseAmount(scanner.nextLine().trim());

        if (service.deposit(accNum, amount)) {
            Account acc = service.findAccount(accNum);
            System.out.printf("[✓] Deposit successful! New Balance: ₹ %.2f%n", acc.getBalance());
        } else {
            System.out.println("[!] Deposit failed. Account not found or amount must be > 0.");
        }
    }

    private void withdrawMoney() {
        System.out.println("\n--- Withdraw Money ---");
        System.out.print("Enter Account Number: ");
        String accNum = scanner.nextLine().trim();
        System.out.print("Enter Amount to Withdraw: ");
        BigDecimal amount = parseAmount(scanner.nextLine().trim());

        if (service.withdraw(accNum, amount)) {
            Account acc = service.findAccount(accNum);
            System.out.printf("[✓] Withdrawal successful! New Balance: ₹ %.2f%n", acc.getBalance());
        } else {
            System.out.println("[!] Withdrawal failed. Account not found, invalid amount, or insufficient balance.");
        }
    }

    private void transferMoney() {
        System.out.println("\n--- Transfer Money ---");
        System.out.print("Enter Sender Account Number: ");
        String senderAcc = scanner.nextLine().trim();
        System.out.print("Enter Recipient Account Number: ");
        String recipientAcc = scanner.nextLine().trim();

        if (senderAcc.equalsIgnoreCase(recipientAcc)) {
            System.out.println("[!] Cannot transfer to the same account.");
            return;
        }

        System.out.print("Enter Amount to Transfer: ");
        BigDecimal amount = parseAmount(scanner.nextLine().trim());

        if (service.transfer(senderAcc, recipientAcc, amount)) {
            Account sender = service.findAccount(senderAcc);
            System.out.printf("[✓] Transfer successful! Sender New Balance: ₹ %.2f%n", sender.getBalance());
        } else {
            System.out.println("[!] Transfer failed. Check accounts, amount, or available balance.");
        }
    }

    private void showStatement() {
        System.out.println("\n--- Account Statement ---");
        System.out.print("Enter Account Number: ");
        Account account = service.findAccount(scanner.nextLine().trim());
        if (account == null) {
            System.out.println("[!] Account not found.");
            return;
        }

        System.out.println("\n======================================================================");
        System.out.printf(" STATEMENT FOR ACCOUNT: %s (%s)%n", account.getAccountNumber(), account.getCustomerID());
        System.out.println("======================================================================");
        System.out.printf("%-19s | %-20s | %10s | %10s%n", "DATE & TIME", "TYPE", "AMOUNT", "BALANCE");
        System.out.println("----------------------------------------------------------------------");

        if (account.getTransactions().isEmpty()) {
            System.out.println("                     No transactions found.                           ");
        } else {
            for (Transaction t : account.getTransactions()) {
                System.out.println(t);
            }
        }
        System.out.println("======================================================================");
        System.out.printf(" Current Balance: ₹ %.2f%n", account.getBalance());
        System.out.println("======================================================================");
    }

    private void listAccounts() {
        System.out.println("\n======================================================================");
        System.out.println("                         ALL ACCOUNTS                                 ");
        System.out.println("======================================================================");
        if (service.getAllAccounts().isEmpty()) {
            System.out.println(" No accounts found.");
        } else {
            System.out.printf("%-10s | %-16s | %-12s | %12s%n", "ACC NO", "CUSTOMER ID", "TYPE", "BALANCE");
            System.out.println("----------------------------------------------------------------------");
            for (Account acc : service.getAllAccounts()) {
                System.out.printf("%-10s | %-16s | %-12s | ₹ %10.2f%n",
                        acc.getAccountNumber(), acc.getCustomerID(), acc.getAccountType(), acc.getBalance());
            }
        }
        System.out.println("======================================================================");
        System.out.printf(" Total Accounts: %d%n", service.getAccountCount());
        System.out.println("======================================================================");
    }

    private void searchAccount() {
        System.out.println("\n--- Search Account ---");
        System.out.print("Enter Account Number: ");
        Account account = service.findAccount(scanner.nextLine().trim());
        if (account == null) {
            System.out.println("[!] Account not found.");
        } else {
            printAccountCard(account);
        }
    }

    private void printAccountCard(Account account) {
        System.out.println("----------------------------------------------");
        System.out.printf(" Account Number : %s%n", account.getAccountNumber());
        System.out.printf(" Customer ID    : %s%n", account.getCustomerID());
        System.out.printf(" Account Type   : %s%n", account.getAccountType());
        System.out.printf(" Current Balance: ₹ %.2f%n", account.getBalance());
        System.out.println("----------------------------------------------");
    }

    private BigDecimal parseAmount(String input) {
        try {
            return new BigDecimal(input);
        } catch (Exception e) {
            return null;
        }
    }
}
