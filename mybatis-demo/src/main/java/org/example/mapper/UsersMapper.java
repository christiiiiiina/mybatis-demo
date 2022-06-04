package org.example.mapper;

import org.example.pojo.Users;

import java.util.List;

/**
 * 数据访问层的接口，规定的数据库中可进行的各种操作
 * @author Administrator
 */
public interface UsersMapper {

    /**
     * 查询全部用户信息
     * @return
     */
    List<Users> getAll();

    /**
     * 根据用户主键查用户
     * @param id
     * @return
     */
    Users getUsersById(int id);

    /**
     * 根据用户名模糊查询用户
     * @param userName
     * @return
     */
    List<Users> getUserByUsername(String userName);

    /**
     * 用户的更新
     * @param users
     * @return
     */
    int update(Users users);

    /**
     * 增加用户
     * @param users
     * @return
     */
    int insert(Users users);

    /**
     * 根据主键删除用户
     * @param id
     * @return
     */
    int delete(int id);
}
