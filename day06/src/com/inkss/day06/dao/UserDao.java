package com.inkss.day06.dao;

import com.inkss.day06.pojo.User;

import java.util.List;

public interface UserDao {

    /**
     * 插入
     *
     * @param user 用户
     * @return id
     */
    public int insertUser(User user);

    /**
     * 根据 ID 删除
     *
     * @param id user 的 id
     * @return 是否成功
     */
    public boolean deleteUser(int id);

    /**
     * 多个删除
     * @param list id 列表
     * @return 是否成功
     */
    public boolean deleteByIDList(List<Integer> list);

    /**
     * 根据 ID 更新
     *
     * @param user user
     */
    public boolean updateUser(User user);

    /**
     * 根据用户名模糊查询
     *
     * @param userName 用户名
     */
    public List<User> selectLikeName(String userName);

    /**
     * 查询所有数据
     *
     * @return user 的集合
     */
    public List<User> selectAllUser();

    /**
     * 根据 id 查询
     *
     * @param id id
     */
    public User selectById(int id);

    /**
     * 根据用户名查询
     *
     * @param username 用户名
     */
    public User selectByName(String username);

}
