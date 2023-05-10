package model;

public class ShoppingCart {
    public static int INDEX;
    private int id;
    private String day;
    private Double totalPrice;

    public ShoppingCart() {
    }

    public ShoppingCart(String day, Double totalPrice) {
        this.id = ++INDEX;
        this.day = day;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

public void displayShoppingCart(){

}

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id=" + id +
                ", day='" + day + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
