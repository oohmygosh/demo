package com.vipicu.demo.boot.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vipicu.demo.boot.entity.User;
import com.vipicu.demo.boot.mapper.UserMapper;
import com.vipicu.demo.boot.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户服务impl
 *
 * @author oohmygosh
 * @since 2023/03/13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public Page<User> page(Page<User> page, User user) {
        return super.page(page, Wrappers.lambdaQuery(user));
    }
}
