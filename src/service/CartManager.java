package service;

import model.CartDetail;

import java.util.ArrayList;
import java.util.List;

public interface CartManager<E> {
    E search();

    E sort();

    E additional();

    E displayInCart();

    E deleteInCart();

    E payment();

    void writeBinary(List<CartDetail> e, String path);

    ArrayList<CartDetail> readBinary(String path);
}
