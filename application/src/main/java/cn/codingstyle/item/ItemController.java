package cn.codingstyle.item;

import cn.codingstyle.config.item.Item;
import cn.codingstyle.config.item.ItemService;
import cn.codingstyle.config.item.ItemRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("items")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public void create(@RequestBody @Valid ItemForm itemForm) {
        ItemRequest request = itemForm.toRequest();
        itemService.newItem(request);
    }

    @GetMapping()
    public List<Item> getList() {
        return itemService.getItemList();
    }

    @GetMapping("/{id}")
    public Item get(@PathVariable int id) {
        return itemService.getItem(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody ItemForm itemForm) {
        ItemRequest request = itemForm.toRequest();
        itemService.updateItem(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        itemService.deleteItem(id);
    }
}
