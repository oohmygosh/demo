package com.vipicu.demo.boot.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vipicu.demo.boot.entity.PageParam;
import com.vipicu.demo.boot.entity.User;
import com.vipicu.demo.boot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户控制器
 *
 * @author oohmygosh
 * @since 2023/03/13
 */
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping("/page")
    public Page<User> getPage(@RequestBody PageParam<User> dto){
        return userService.page(dto.page(), dto.getData());
    }

    @GetMapping("/get")
    public User get(@RequestParam Long id) {
        return userService.getById(id);
    }

    @PostMapping("/update")
    public boolean update(@RequestBody User user) {
        return userService.updateById(user);
    }

    @PostMapping("/create")
    public boolean create(@RequestBody User user) {
        return userService.save(user);
    }

    @PostMapping("/delete")
    public boolean delete(@RequestBody List<Long> ids) {
        return userService.removeByIds(ids);
    }
}
