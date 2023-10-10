package com.nicr0n.user.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
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
 * @since 2023/10/09 05:50
 */
@Getter
@Setter
@TableName("sys_department")
@ApiModel(value = "SysDepartment对象", description = "")
public class SysDepartment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("部门ID")
    @TableId(value = "department_id", type = IdType.AUTO)
    private Long departmentId;

    @ApiModelProperty("父部门ID")
    @TableField("parent_id")
    private Long parentId;

    @ApiModelProperty("部门名称")
    @TableField("department_name")
    private String departmentName;

    @ApiModelProperty("部门排序")
    @TableField("sort")
    private Integer sort;

    @ApiModelProperty("负责人")
    @TableField("principle")
    private String principle;

    @ApiModelProperty("电话号码")
    @TableField("telephone")
    private String telephone;

    @ApiModelProperty("email")
    @TableField("email")
    private String email;

    @ApiModelProperty("部门状态(0正常 1停用)")
    @TableField("status")
    private Integer status;

    @ApiModelProperty("删除标志(true删除 false未删除)")
    @TableField("delete_flag")
    @TableLogic
    private Boolean deleteFlag;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("创建人ID")
    @TableField("create_by")
    private Long createBy;

    @ApiModelProperty("修改时间")
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty("修改人ID")
    @TableField("update_by")
    private LocalDateTime updateBy;
}
