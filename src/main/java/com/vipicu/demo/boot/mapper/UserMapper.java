package com.vipicu.demo.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vipicu.demo.boot.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户映射器
 *
 * @author oohmygosh
 * @since 2023/03/13
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}