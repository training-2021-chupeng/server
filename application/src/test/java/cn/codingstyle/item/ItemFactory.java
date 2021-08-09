package cn.codingstyle.item;

import cn.codingstyle.base.BaseFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ItemFactory extends BaseFactory {
    private final ItemDAO dao;

    public ItemFactory(ItemDAO dao, JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.dao = dao;
    }

    @Override
    protected String getTableName() {
        return "item";
    }

    public List<ItemDO> all() {
        return StreamSupport.stream(dao.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public void save(ItemDO itemDO) {
        dao.save(itemDO);
    }

    public Optional<ItemDO> findById(Integer id) {
        return dao.findById(id);
    }
}
