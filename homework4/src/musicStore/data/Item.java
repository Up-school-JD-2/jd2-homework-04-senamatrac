package musicStore.data;

import java.math.BigDecimal;

public abstract class Item {
    protected BigDecimal price;
    protected String title;
    protected ItemType itemType;
    protected Singer singer;

    public Item(Singer singer, String title, BigDecimal price, ItemType itemType) {
        this.singer = singer;
        this.price = price;
        this.title = title;
        this.itemType = itemType;
    }

    //region GETTER SETTER
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public ItemType getItemType() {
        return itemType;
    }
    //endregion

}
