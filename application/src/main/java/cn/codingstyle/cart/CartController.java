package cn.codingstyle.cart;

import cn.codingstyle.config.cart.CartList;
import cn.codingstyle.config.cart.CartService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("shopping-cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("add-item-to-cart")
    public CartList addItem(String barcode, int num) {
        return cartService.addItem(barcode, num);
    }
}
