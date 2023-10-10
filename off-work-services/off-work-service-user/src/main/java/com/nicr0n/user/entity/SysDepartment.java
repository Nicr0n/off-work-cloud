package com.nicr0n.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

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
@Schema(description = "SysDepartment对象")
public class SysDepartment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "部门ID")
    @TableId(value = "department_id", type = IdType.AUTO)
    private Long departmentId;

    @Schema(description = "父部门ID")
    @TableField("parent_id")
    private Long parentId;

    @Schema(description = "部门名称")
    @TableField("department_name")
    private String departmentName;

    @Schema(description = "部门排序")
    @TableField("sort")
    private Integer sort;

    @Schema(description = "负责人")
    @TableField("principle")
    private String principle;

    @Schema(description = "电话号码")
    @TableField("telephone")
    private String telephone;

    @Schema(description = "email")
    @TableField("email")
    private String email;

    @Schema(description = "部门状态(0正常 1停用)")
    @TableField("status")
    private Integer status;

    @Schema(description = "删除标志(true删除 false未删除)")
    @TableField("delete_flag")
    @TableLogic
    private Boolean deleteFlag;

    @Schema(description = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @Schema(description = "创建人ID")
    @TableField("create_by")
    private Long createBy;

    @Schema(description = "修改时间")
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    @Schema(description = "修改人ID")
    @TableField("update_by")
    private LocalDateTime updateBy;
}
