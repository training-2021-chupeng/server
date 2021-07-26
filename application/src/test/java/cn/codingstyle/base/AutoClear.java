package cn.codingstyle.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Stream;

@Slf4j
@Service
public class AutoClear {
    public void clear(Object bean) {
        Stream.of(bean.getClass().getDeclaredFields())
                .map(field -> this.getFieldValue(field,bean))
                .filter(Objects::nonNull)
                .filter(o -> o instanceof Clearable)
                .map(o -> (Clearable) o)
                .forEach(Clearable::clear);
    }

    private Object getFieldValue(java.lang.reflect.Field field,Object bean) {
        try {
            field.setAccessible(true);
            return field.get(bean);
        } catch (IllegalAccessException e) {
            log.error("", e);
        }
        return null;
    }
}
