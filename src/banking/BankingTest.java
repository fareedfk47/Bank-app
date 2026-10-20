package banking;

import banking.model.Account;
import banking.service.BankingService;

import java.io.File;
import java.math.BigDecimal;

public class BankingTest {
    private static final String TEST_DATA_FILE = "test_accounts.dat";

    public static void main(String[] args) {
        System.out.println("Running banking integrity and persistence tests...\n");

        new File(TEST_DATA_FILE).delete();

        testAccountCreationAndBalanceIntegrity();
        testDepositIntegrity();
        testWithdrawIntegrity();
        testTransferIntegrity();
        testPersistenceNoDataLoss();

        new File(TEST_DATA_FILE).delete();

        System.out.println("\n[✓] ALL TESTS PASSED! No balance errors or data loss detected.");
    }

    private static void testAccountCreationAndBalanceIntegrity() {
        BankingService service = new BankingService(TEST_DATA_FILE);
        Account acc = service.createAccount("CUST100", "SAVINGS", new BigDecimal("1000.00"));

        assertEquals(new BigDecimal("1000.00"), acc.getBalance(), "Initial balance mismatch");
        assertEquals("ACC001", acc.getAccountNumber(), "Account number mismatch");

        // Negative initial balance should be rejected
        Account invalid = service.createAccount("CUST101", "SAVINGS", new BigDecimal("-100.00"));
        assertNull(invalid, "Negative initial deposit must not create account");
        System.out.println("  ✓ Account creation & balance integrity verified.");
    }

    private static void testDepositIntegrity() {
        BankingService service = new BankingService(TEST_DATA_FILE);
        Account acc = service.findAccount("ACC001");

        // Valid deposit
        boolean ok = service.deposit(acc.getAccountNumber(), new BigDecimal("250.50"));
        assertTrue(ok, "Valid deposit should succeed");
        assertEquals(new BigDecimal("1250.50"), acc.getBalance(), "Balance after deposit incorrect");

        // Invalid zero deposit
        boolean zeroOk = service.deposit(acc.getAccountNumber(), BigDecimal.ZERO);
        assertFalse(zeroOk, "Zero deposit must be rejected");
        assertEquals(new BigDecimal("1250.50"), acc.getBalance(), "Balance changed on zero deposit");

        // Invalid negative deposit
        boolean negOk = service.deposit(acc.getAccountNumber(), new BigDecimal("-50.00"));
        assertFalse(negOk, "Negative deposit must be rejected");
        assertEquals(new BigDecimal("1250.50"), acc.getBalance(), "Balance changed on negative deposit");
        System.out.println("  ✓ Deposit validation & calculation verified.");
    }

    private static void testWithdrawIntegrity() {
        BankingService service = new BankingService(TEST_DATA_FILE);
        Account acc = service.findAccount("ACC001");

        // Valid withdraw
        boolean ok = service.withdraw(acc.getAccountNumber(), new BigDecimal("250.50"));
        assertTrue(ok, "Valid withdrawal should succeed");
        assertEquals(new BigDecimal("1000.00"), acc.getBalance(), "Balance after withdrawal incorrect");

        // Insufficient funds
        boolean overdraw = service.withdraw(acc.getAccountNumber(), new BigDecimal("5000.00"));
        assertFalse(overdraw, "Overdraft must be rejected");
        assertEquals(new BigDecimal("1000.00"), acc.getBalance(), "Balance changed on failed overdraft");

        // Negative withdraw
        boolean neg = service.withdraw(acc.getAccountNumber(), new BigDecimal("-100.00"));
        assertFalse(neg, "Negative withdrawal must be rejected");
        assertEquals(new BigDecimal("1000.00"), acc.getBalance(), "Balance changed on negative withdrawal");
        System.out.println("  ✓ Withdrawal validation & overdraft protection verified.");
    }

    private static void testTransferIntegrity() {
        BankingService service = new BankingService(TEST_DATA_FILE);
        Account recipient = service.createAccount("CUST200", "CURRENT", new BigDecimal("500.00"));

        // Transfer 300 from ACC001 to ACC002
        boolean ok = service.transfer("ACC001", recipient.getAccountNumber(), new BigDecimal("300.00"));
        assertTrue(ok, "Valid transfer should succeed");

        Account sender = service.findAccount("ACC001");
        recipient = service.findAccount(recipient.getAccountNumber());

        assertEquals(new BigDecimal("700.00"), sender.getBalance(), "Sender balance incorrect after transfer");
        assertEquals(new BigDecimal("800.00"), recipient.getBalance(), "Recipient balance incorrect after transfer");

        // Transfer more than sender balance
        boolean overdrawTransfer = service.transfer("ACC001", recipient.getAccountNumber(), new BigDecimal("9999.00"));
        assertFalse(overdrawTransfer, "Transfer exceeding balance must be rejected");
        assertEquals(new BigDecimal("700.00"), sender.getBalance(), "Sender balance changed on failed transfer");
        assertEquals(new BigDecimal("800.00"), recipient.getBalance(), "Recipient balance changed on failed transfer");
        System.out.println("  ✓ Transfer integrity & balance conservation verified.");
    }

    private static void testPersistenceNoDataLoss() {
        // Create new service instance reading from the saved file
        BankingService restoredService = new BankingService(TEST_DATA_FILE);

        assertEquals(2, restoredService.getAccountCount(), "Account count lost during persistence");
        Account acc1 = restoredService.findAccount("ACC001");
        Account acc2 = restoredService.findAccount("ACC002");

        assertNotNull(acc1, "ACC001 not found after reloading file");
        assertNotNull(acc2, "ACC002 not found after reloading file");

        assertEquals(new BigDecimal("700.00"), acc1.getBalance(), "ACC001 balance corrupted after reload");
        assertEquals(new BigDecimal("800.00"), acc2.getBalance(), "ACC002 balance corrupted after reload");

        // Check transaction histories are intact
        assertTrue(acc1.getTransactions().size() >= 4, "ACC001 transactions lost during reload");
        assertTrue(acc2.getTransactions().size() >= 2, "ACC002 transactions lost during reload");
        System.out.println("  ✓ File persistence & data loss prevention verified.");
    }

    private static void assertEquals(Object expected, Object actual, String message) {
        if (expected == null && actual == null) return;
        if (expected != null && expected.equals(actual)) return;
        throw new AssertionError(message + " (Expected: " + expected + ", Actual: " + actual + ")");
    }

    private static void assertTrue(boolean condition, String message) {
        if (!condition) throw new AssertionError("Condition failed: " + message);
    }

    private static void assertFalse(boolean condition, String message) {
        if (condition) throw new AssertionError("Condition failed: " + message);
    }

    private static void assertNotNull(Object obj, String message) {
        if (obj == null) throw new AssertionError("Null check failed: " + message);
    }

    private static void assertNull(Object obj, String message) {
        if (obj != null) throw new AssertionError("Expected null but got: " + obj + " (" + message + ")");
    }
}
