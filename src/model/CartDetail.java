package model;

public class CartDetail {
    public static int INDEX;
    private int id;
    private Product product;
    private ShoppingCart shoppingCart;
    private int quantity;
    private boolean paid;

    public CartDetail() {
    }

    public CartDetail(Product product, ShoppingCart shoppingCart, int quantity, boolean paid) {
        this.id = ++INDEX;
        this.product = product;
        this.shoppingCart = shoppingCart;
        this.quantity = quantity;
        this.paid = paid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public void displayCartDetail(){

    }

    @Override
    public String toString() {
        return "CartDetail{" +
                "id=" + id +
                ", product=" + product +
                ", shoppingCart=" + shoppingCart +
                ", quantity=" + quantity +
                ", paid=" + paid +
                '}';
    }
}
