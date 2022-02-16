package com.nicr0n.user.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.nicr0n.db.handler.TimestamptzTypeHandler;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author Nicr0n
 * @since 2021/10/19 13:32
 */
@Getter
@Setter
//重要 TableName注解必须增加 autoResultMap = true 否则无法处理typeHandler
@TableName(value = "sys_role",autoResultMap = true)
@ApiModel(value = "SysRole对象", description = "")
public class SysRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("角色ID")
    @TableId(value = "role_id", type = IdType.AUTO)
    private Long roleId;

    @ApiModelProperty("角色名称")
    @TableField(value = "name")
    private String name;

    @ApiModelProperty("角色权限code")
    @TableField("code")
    private String code;

    @ApiModelProperty("角色排序")
    @TableField("sort")
    private Integer sort;

    @ApiModelProperty("角色数据作用域")
    @TableField("scope")
    private Integer scope;

    @ApiModelProperty("角色描述")
    @TableField("description")
    private String description;

    @ApiModelProperty("角色状态（0正常 1停用)")
    @TableField("status")
    private Integer status;

    @ApiModelProperty("删除标志(true删除 false未删除)")
    @TableField("delete_flag")
    @TableLogic(value = "false",delval = "true")
    private Boolean deleteFlag;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT,typeHandler = TimestamptzTypeHandler.class)
    private LocalDateTime createTime;

    @ApiModelProperty("创建人ID((为NULL则是系统创建))")
    @TableField("create_by")
    private Long createBy;

    @ApiModelProperty("修改时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE,typeHandler = TimestamptzTypeHandler.class)
    private LocalDateTime updateTime;

    @ApiModelProperty("修改人ID(为NULL则是系统创建)")
    @TableField("update_by")
    private Long updateBy;


}
