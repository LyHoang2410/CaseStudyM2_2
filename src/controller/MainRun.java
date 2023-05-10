package controller;

import model.Account;
import model.Product;
import service.implement.AccountManager;
import service.implement.ProductManager;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class MainRun {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ProductManager productManager = new ProductManager(scanner);
        AccountManager accountManager = new AccountManager(scanner);
        accountMenu(accountManager, productManager, scanner);

    }

    private static void accountMenu(AccountManager accountManager, ProductManager productManager, Scanner scanner) {
        do {
            System.out.println("----MENU----");
            System.out.println("1. Login");
            System.out.println("2. Registration");
            System.out.println("0. Exit");
            System.out.println("Enter your choice");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    Account accountLogin = accountManager.Login();
                    if (accountLogin != null) {
                        String accessLevel = accountLogin.getAccessLevel();
                        if (accessLevel.equals("ADMIN")) {
                            System.out.println("Hello, " + accountLogin.getUsername() + " you have admin access.");

                            adminMenu(accountManager, productManager, scanner);
                        } else if (accessLevel.equals("USER")) {
                            System.out.println("Hello, " + accountLogin.getUsername() + " you have user access.");
                            userMenu(accountManager, productManager, scanner);
                        }
                    } else {
                        System.out.println("Invalid username or password. Please check your username and password.");
                    }

                    break;
                case 2:
                    Account accountRegister = accountManager.create();
                    System.out.println("Account created is: ");
                    accountManager.displayOne(accountRegister);
                    break;
                case 0:
                    System.exit(0);
            }
        } while (true);
    }

    private static void userMenu(AccountManager accountManager, ProductManager productManager, Scanner scanner) {
        do {
            System.out.println("----MENU----");
            System.out.println("1. Profile");
            System.out.println("2. Edit profile");
            System.out.println("3. Show all product");
            System.out.println("4. Search for a product");
            System.out.println("5. Sort products");
            System.out.println("6. Add to shopping cart");
            System.out.println("7. Checking Shopping Cart");
            System.out.println("8. Delete product on Shopping Cart");
            System.out.println("9. Payment processing");
            System.out.println("10. Log Out");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    accountManager.displayProfile();
                    break;
                case 2:
                    Account accountUpdate = accountManager.update();
                    System.out.println("Account updated is: ");
                    accountManager.displayOne(accountUpdate);
                    break;
                case 3:
                    productManager.displayAll();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 0:
                    System.exit(0);
            }
        } while (true);
    }

    private static void adminMenu(AccountManager accountManager, ProductManager productManager, Scanner scanner) {

        do {
            System.out.println("----MENU----");
            System.out.println("1. Profile");
            System.out.println("2. Show all user account");
            System.out.println("3. Create new product");
            System.out.println("4. Update product");
            System.out.println("5. Delete product");
            System.out.println("6 Log Out");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:

                    break;
                case 2:
                    accountManager.displayAllUser();
                    break;
                case 3:
                    Product createProduct = productManager.create();
                    System.out.println("New products created is: ");
                    productManager.displayProduct(createProduct);
                    break;
                case 4:
                    Product updateProduct = productManager.update();
                    System.out.println("new product update is: ");
                    productManager.displayProduct(updateProduct);
                    break;
                case 5:
                    Product deleteProduct = productManager.delete();
                    System.out.println("product delete is: ");
                    productManager.displayProduct(deleteProduct);
                    break;
                case 6:
                    accountMenu(accountManager, productManager, scanner);
                    break;
                case 0:
                    System.exit(0);
            }
        } while (true);
    }
}
