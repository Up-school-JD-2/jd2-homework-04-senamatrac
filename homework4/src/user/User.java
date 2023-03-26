package user;

import Shopping.Cart;

public class User {
    private String name;
    private Cart cart;

    public User(String name) {
        this.name = name;
    }

    public User(String name, Cart cart) {
        this(name);
        this.cart = cart;
    }

    //region GETTER SETTER
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
    //endregion


}
