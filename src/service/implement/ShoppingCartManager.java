package service.implement;

import model.CartDetail;
import service.CartManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingCartManager implements CartManager<CartDetail> {
    private final Scanner scanner;
    private final ArrayList<CartDetail> cartDetails;
    private final String PATH_FILE = "C:\\Users\\Asus\\Desktop\\CaseStudyM2_2\\src\\data\\ShoppingCart";

    public ShoppingCartManager(Scanner scanner) {
        this.scanner = scanner;
        cartDetails = readBinary(PATH_FILE);
    }

    @Override
    public CartDetail search() {

        return null;
    }

    @Override
    public CartDetail sort() {

        return null;
    }

    @Override
    public CartDetail additional() {

        return null;
    }

    @Override
    public CartDetail displayInCart() {

        return null;
    }

    @Override
    public CartDetail deleteInCart() {

        return null;
    }

    @Override
    public CartDetail payment() {

        return null;
    }

    @Override
    public void writeBinary(List<CartDetail> e, String path) {
        File file = new File(path);
        try (ObjectOutputStream objectOutputStream
                     = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(e);
        } catch (IOException ioException) {
            System.err.println(ioException.getMessage());
        }
    }

    @Override
    public ArrayList<CartDetail> readBinary(String path) {
        File file = new File(path);
        ArrayList<CartDetail> classrooms = new ArrayList<>();
        try (ObjectInputStream objectInputStream
                     = new ObjectInputStream(new FileInputStream(file))) {
            classrooms = (ArrayList<CartDetail>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException ioException) {
            System.err.println(ioException.getMessage());
        }
        return classrooms;
    }
}
