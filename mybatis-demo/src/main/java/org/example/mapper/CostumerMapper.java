package org.example.mapper;

import org.example.pojo.Costumer;

/**
 * @author Administrator
 */
public interface CostumerMapper {

    /**
     * 根据客户的id查询客户的所有信息并同时查询该客户名下的所有订单
     * @param id
     * @return
     */
    Costumer getById(Integer id);
}
