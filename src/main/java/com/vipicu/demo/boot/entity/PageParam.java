package com.vipicu.demo.boot.entity;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.sql.SqlInjectionUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

import java.io.Serial;
import java.io.Serializable;

/**
 * 分页查询参数
 *
 * @author oohmygosh
 * @since 2023/03/13
 */
@Getter
@Setter
public class PageParam<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 请求数据的页码
     */
    private Long page;

    /**
     * 每页条数
     */
    private Long pageSize;

    /**
     * 查询实体对象
     */
    private T data;

    /**
     * 排序
     */
    private OrderItem orderItem;

    public <E> Page<E> page() {
        return page(20L);
    }
    public <E> Page<E> page(OrderItem orderItem) {
        Page<E> p = page(20L);
        p.addOrder(orderItem);
        return p;
    }

    public <E> Page<E> page(long size) {
        if (null == this.pageSize || this.pageSize < 1L) {
            this.pageSize = size;
        }
        if (null == this.page) {
            this.page = 1L;
        }
        Page<E> ePage = new Page<>(this.page, this.pageSize);
        if (orderItem != null && StringUtils.hasLength(orderItem.getColumn()) && !SqlInjectionUtils.check(orderItem.getColumn())) {
            orderItem.setColumn(orderItem.getColumn().replaceAll("(?<=[a-z])([A-Z])", "_$1").toLowerCase());
            ePage.addOrder(orderItem);
        }
        return ePage;
    }
}
