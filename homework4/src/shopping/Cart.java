package shopping;

import musicStore.data.Item;
import user.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Item> items;

    private User user;

    private BigDecimal totalPrice ;

    public Cart(User user) {
        this.user = user;
        clear();
        user.setCart(this);
    }

    //region GETTER SETTER
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
    //endregion


    public void addItem(Item item){
        items.add(item);
        totalPrice = totalPrice.add(item.getPrice());
    }
    public void removeItem(Item item){
        if (items.contains(item)) {
            items.add(item);
            totalPrice = totalPrice.subtract(item.getPrice());
        }
    }

    public void clear(){
        items = new ArrayList<>();
        totalPrice = BigDecimal.valueOf(0);
    }

    public void purchase(){
        clear();
    }
}
