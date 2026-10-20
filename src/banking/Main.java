package banking;

import banking.service.BankingService;
import banking.ui.BankingMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankingService service = new BankingService();
        BankingMenu menu = new BankingMenu(service, scanner);
        menu.start();
    }
}
