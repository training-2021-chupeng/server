package cn.codingstyle.cart;

import cn.codingstyle.config.cart.CartService;
import cn.codingstyle.config.item.ItemRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CartBeanConfig {
    @Bean
    public CartService cartService(ItemRepository itemRepository) {
        return new CartService(itemRepository);
    }
}
