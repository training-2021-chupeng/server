package cn.codingstyle.item;

import cn.codingstyle.config.item.ItemRequest;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Getter
public class ItemForm {
    @NotBlank
    private String barcode;
    @NotBlank
    private String name;
    private String unit;
    private BigDecimal price;
    private String type;

    public ItemRequest toRequest()
    {
        return ItemRequest.builder()
                .name(name)
                .barcode(barcode)
                .price(price)
                .type(type)
                .unit(unit)
                .build();
    }
}
