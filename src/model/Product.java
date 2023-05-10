package model;

public class Product {
    public static int INDEX;
    private int id;
    private String name;
    private Double price;
    private String origin;

    public Product() {
    }

    public Product(String name, Double price, String origin) {
        this.id = ++INDEX;
        this.name = name;
        this.price = price;
        this.origin = origin;
    }

    public Product(int id, String name, Double price, String origin) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.origin = origin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void display() {
        System.out.printf("%-10s%-15s%-10s%s",
                this.id, this.name, this.price, this.origin + "\n");
    }
}
