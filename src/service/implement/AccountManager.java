package service.implement;

import io.IOInterface;
import model.Account;
import service.Manager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountManager implements Manager<Account>, IOInterface<Account> {
    private final Scanner scanner;
    private final ArrayList<Account> accounts;
    private final Validate validate;
    private final String PATH_FILE = "C:\\Users\\Asus\\Desktop\\CaseStudyM2_2\\src\\data\\Account";

    public AccountManager(Scanner scanner) throws IOException {
        this.scanner = scanner;
        accounts = read(PATH_FILE);
        validate = new Validate();
        checkDefaultIndex();
    }

    private void checkDefaultIndex() {
        if (accounts.isEmpty()) {
            Account.INDEX = 0;
        } else {
            Account.INDEX = accounts.get(accounts.size() - 1).getId();
        }
    }

    private String getUsername() {
        System.out.println("Enter username: ");
        String username;
        do {
            username = scanner.nextLine();
            if (validate.validateUsername(username)) {
                return username;
            } else {    //  user đã tồn tại mời nhập lại
                System.out.println("Please re-enter: ");
            }
        } while (true);
    }

    private String getPassword() {
        System.out.println("Enter password: ");
        String password;
        do {
            password = scanner.nextLine();
            if (validate.validatePassword(password)) {
                return password;
            } else {
                System.out.println("Please re-enter: ");
            }
        } while (true);
    }

    private String getEmail() {
        System.out.println("Enter email: ");
        String email;
        do {
            email = scanner.nextLine();
            if (validate.validateEmail(email)) {
                return email;
            } else {     // thêm phần email đã tồn tại, mời nhập lại
                System.out.println("Please re-enter: ");
            }
        } while (true);
    }

    private String getPhoneNumber() {
        System.out.println("Enter your phone number: ");
        String phoneNumber;
        do {
            phoneNumber = scanner.nextLine();
            if (validate.validatePhoneNumber(phoneNumber)) {
                return phoneNumber;
            } else {
                System.out.println("Please re-enter: ");
            }
        } while (true);
    }

    public Account Login() {
        System.out.println("Enter your username: ");
        String username = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        for (Account account : accounts) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
            }
            return account;
        }
        return null;
    }

    @Override
    public Account create() {
        String username = getUsername();
        if (username == null) return null;
        String password = getPassword();
        if (password == null) return null;
        String email = getEmail();
        if (email == null) return null;
        String phoneNumber = getPhoneNumber();
        if (phoneNumber == null) return null;
        Account account = new Account(username, password, email, phoneNumber);
        accounts.add(account);
        write(accounts, PATH_FILE);
        return account;
    }


    @Override
    public Account update() {
        Account account = getById();
        if (account != null) {
            System.out.println("Enter your new username: ");
            String username = scanner.nextLine();
            if (!username.equals("")) {
                account.setUsername(username);
            }
            System.out.println("Enter your new password: ");
            String password = scanner.nextLine();
            if (!password.equals("")) {
                account.setPassword(password);
            }
            System.out.println("Enter your new email: ");
            String email = scanner.nextLine();
            if (!email.equals("")) {
                account.setEmail(email);
            }
            System.out.println("Enter your new phoneNumber: ");
            String phoneNumber = scanner.nextLine();
            if (!phoneNumber.equals("")) {
                account.setPhoneNumber(phoneNumber);
            }
        }
        write(accounts, PATH_FILE);
        return account;
    }

    @Override
    public Account delete() {
        return null;
    }

    @Override
    public Account getById() {
        displayAll();
        System.out.println("Enter Id you want to choice: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Account account : accounts) {
            if (account.getId() == id) {
                return account;
            }
        }
        return null;
    }

    @Override
    public void displayAll() {
        System.out.printf("%-5s%-15s%-20s%-25s%-20s%s",
                "ID", "USERNAME", "PASSWORD", "EMAIL", "PHONE NUMBER", "ACCESS LEVEL\n");
        for (Account account : accounts) {
            account.display();
        }
    }

    public void displayAllUser() {
        System.out.printf("%-5s%-15s%-20s%-25s%-20s%s",
                "ID", "USERNAME", "PASSWORD", "EMAIL", "PHONE NUMBER", "ACCESS LEVEL\n");
        for (Account account : accounts) {
            if (account.getAccessLevel().equals("USER")) {
                System.out.printf("%-5s%-15s%-20s%-25s%-20s%s",
                        account.getId(), account.getUsername(), account.getPassword(),
                        account.getEmail(), account.getPhoneNumber(), account.getAccessLevel());
                System.out.println();
            }
        }
    }

    public void displayProfile() {
        Account account = Login();
        if (account != null) {
            System.out.printf("%-5s%-15s%-20s%-25s%-20s%s",
                    account.getId(), account.getUsername(), account.getPassword(),
                    account.getEmail(), account.getPhoneNumber(), account.getAccessLevel());
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    public void displayOne(Account account) {
        if (account != null) {
            account.display();
        } else {
            System.out.println("Not exist this object!");
        }
    }

    @Override
    public void write(List<Account> e, String path) {
        File file = new File(path);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (Account account : e) {
                bufferedWriter.write(account.getId() + "," + account.getUsername() + ","
                        + account.getPassword() + "," + account.getEmail() + ","
                        + account.getPhoneNumber() + "," + account.getAccessLevel() + "\n");
            }
        } catch (IOException ioException) {
            System.err.println(ioException.getMessage());
        }
    }

    @Override
    public ArrayList<Account> read(String path) throws IOException {
        File file = new File(path);
        ArrayList<Account> accounts = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String data;
            while ((data = bufferedReader.readLine()) != null) {
                String[] strings = data.split(",");
                accounts.add(new Account(Integer.parseInt(strings[0]), strings[1], strings[2], strings[3], strings[4], strings[5]));
            }
        } catch (IOException ioException) {
            System.err.println(ioException.getMessage());
        }
        return accounts;
    }
}
