package cn.codingstyle.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;

@Slf4j
public abstract class BaseFactory implements Clearable {
    protected JdbcTemplate jdbcTemplate;

    public void clear() {
        if (getTableName() != null) {
            String sql = "truncate table " + getTableName();
            log.info(sql);
            jdbcTemplate.execute(sql);
        }
    }

    protected abstract String getTableName();

}
