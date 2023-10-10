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
@TableName("sys_position")
@Schema(description = "SysPosition对象")
public class SysPosition implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "职位ID)")
    @TableId("position_id")
    private Long positionId;

    @Schema(description = "职位名称")
    @TableField("position_name")
    private String positionName;

    @Schema(description = "职位权限code")
    @TableField("code")
    private String code;

    @Schema(description = "排列顺序")
    @TableField("sort")
    private Integer sort;

    @Schema(description = "职位描述")
    @TableField("description")
    private String description;

    @Schema(description = "职位状态(0正常 1停用)")
    @TableField("status")
    private Integer status;

    @Schema(description = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @Schema(description = "创建人ID")
    @TableField("create_by")
    private Long createBy;

    @Schema(description = "修改时间")
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    @Schema(description = "删除标志(true删除 false未删除)")
    @TableField("update_by")
    private Long updateBy;

    @Schema(description = "删除标志(true删除 false未删除)")
    @TableField("delete_flag")
    @TableLogic
    private Boolean deleteFlag;
}
