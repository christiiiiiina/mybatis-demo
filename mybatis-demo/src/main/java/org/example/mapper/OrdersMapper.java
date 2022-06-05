package org.example.mapper;

import org.example.pojo.Orders;

/**
 * @author Administrator
 */
public interface OrdersMapper {

    /**
     * 根据主键查询订单，并同时查询下此订单的客户信息
     * @param id
     * @return
     */
    Orders getById(Integer id);
}
