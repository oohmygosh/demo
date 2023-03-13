package com.vipicu.demo.boot.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

/**
 * 用户
 *
 * @author oohmygosh
 * @since 2023/03/13
 */
@Data
@TableName(autoResultMap = true)
public class User {
    @TableId
    private Long id;
    @NotBlank
    private String name;
    private Integer age;
    private String sex;
    private String phone;
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<String> address;
}
