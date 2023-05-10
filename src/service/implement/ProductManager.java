package service.implement;

import io.IOInterface;
import model.Product;
import service.Manager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager implements Manager<Product>, IOInterface<Product> {

    private final Scanner scanner;
    private final ArrayList<Product> products;
    private final String PATH_FILE = "C:\\Users\\Asus\\Desktop\\CaseStudyM2_2\\src\\data\\Product";

    public ProductManager(Scanner scanner) throws IOException {
        this.scanner = scanner;
        products = read(PATH_FILE);
        checkDefaultIndex();
    }

    private void checkDefaultIndex() {
        if (products.isEmpty()) {
            Product.INDEX = 0;
        } else {
            Product.INDEX = products.get(products.size() - 1).getId();
        }
    }

    @Override
    public Product create() {
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();
        System.out.println("Enter product price: ");
        Double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter product origin: ");
        String origin = scanner.nextLine();
        Product product = new Product(name, price, origin);
        products.add(product);
        write(products, PATH_FILE);
        return product;
    }

    @Override
    public Product update() {
        Product product = getById();
        if (product != null) {
            System.out.println("Enter new product name: ");
            String name = scanner.nextLine();
            if (!name.equals("")) {
                product.setName(name);
            }
            System.out.println("Enter new product price: ");
            String price = scanner.nextLine();
            if (!price.equals("")) {
                product.setPrice(Double.parseDouble(price));
            }
            System.out.println("Enter new product origin: ");
            String origin = scanner.nextLine();
            if (!origin.equals("")) {
                product.setOrigin(origin);
            }
        }
        write(products, PATH_FILE);
        return product;
    }

    @Override
    public Product delete() {
        Product product = getById();
        if (product != null) {
            products.remove(product);
        }
        write(products, PATH_FILE);
        return product;
    }

    @Override
    public Product getById() {
        displayAll();
        System.out.println("Enter Id your want to find: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void displayAll() {
        System.out.printf("%-10s%-15s%-10s%s",
                "ID", "NAME", "PRICE", "ORIGIN\n");
        for (Product product : products) {
            product.display();
        }
    }

    public void displayProduct(Product product) {
        if (product != null) {
            product.display();
        } else {
            System.out.println("This object does not exist!");
        }
    }

    @Override
    public void write(List<Product> e, String path) {
        File file = new File(path);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (Product product : e) {
                bufferedWriter.write(product.getId() + "," + product.getName() + ","
                        + product.getPrice() + "," + product.getOrigin() + "\n");
            }
        } catch (IOException ioException) {
            System.err.println(ioException.getMessage());
        }
    }

    @Override
    public ArrayList<Product> read(String path) {
        File file = new File(path);
        ArrayList<Product> products = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String data;
            while ((data = bufferedReader.readLine()) != null) {
                String[] strings = data.split(",");
                products.add(new Product(Integer.parseInt(strings[0]), strings[1], Double.parseDouble(strings[2]), strings[3]));
            }
        } catch (IOException ioException) {
            System.err.println(ioException.getMessage());
        }
        return products;
    }
}
