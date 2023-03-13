package com.vipicu.demo.boot.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.vipicu.demo.boot.entity.User;

/**
 * 用户服务
 *
 * @author oohmygosh
 * @since 2023/03/13
 */
public interface UserService extends IService<User> {
    /**
     * 分页
     *
     * @param page 页面
     * @param user 用户
     * @return {@link Page}<{@link User}>
     */
    Page<User> page(Page<User> page, User user);
}
