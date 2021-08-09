package cn.codingstyle.config.cart;

import cn.codingstyle.config.item.Item;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
public class CartList {
    private final List<ItemInCart> itemList;
    private BigDecimal totalPrice;

    public CartList() {
        itemList = new ArrayList<>();
        totalPrice = BigDecimal.valueOf(0);
    }

    public void add(int num, Item item) {
        addToCart(num, item);
        totalPrice = totalPrice.add(item.getPrice().multiply(BigDecimal.valueOf(num)));
    }

    private void addToCart(int num, Item item) {
        Optional<ItemInCart> itemInCart = getItem(item.getBarcode());
        if (itemInCart.isPresent()) {
            itemInCart.get().add(num);
        } else {
            itemList.add(new ItemInCart(item, num));
        }
    }

    private Optional<ItemInCart> getItem(String barcode) {
        return itemList.stream()
                .filter(a -> a.getBarcode().equals(barcode)).findFirst();
    }
}
