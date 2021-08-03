package cn.codingstyle.item;

import cn.codingstyle.config.ItemRepository;
import cn.codingstyle.config.ItemService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ItemBeanConfig {
    @Bean
    public ItemService itemService(ItemRepository itemRepository) {
        return new ItemService(itemRepository);
    }
}