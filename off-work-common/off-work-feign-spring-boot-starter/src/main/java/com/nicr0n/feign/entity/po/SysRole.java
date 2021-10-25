package com.nicr0n.feign.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author: Nicr0n
 * @date: 2021/10/25    17:48
 * @email: Nicr0nFF@gmail.com
 */
@Getter
@Setter
@TableName(value = "sys_role",autoResultMap = true)
public class SysRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "role_id", type = IdType.AUTO)
    private Long roleId;

    @TableField(value = "name")
    private String name;

    @TableField("code")
    private String code;

    @TableField("sort")
    private Integer sort;

    @TableField("scope")
    private Integer scope;

    @TableField("description")
    private String description;

    @TableField("status")
    private Integer status;

    @TableField("delete_flag")
    private Boolean deleteFlag;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField("create_by")
    private Long createBy;

    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    @TableField("update_by")
    private Long updateBy;


}