package com.nicr0n.user.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
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
@TableName("sys_position")
@ApiModel(value = "SysPosition对象", description = "")
public class SysPosition implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("position_id")
    private Long positionId;

    @ApiModelProperty("职位名称")
    @TableField("position_name")
    private String positionName;

    @ApiModelProperty("职位权限code")
    @TableField("code")
    private String code;

    @ApiModelProperty("排列顺序")
    @TableField("sort")
    private Integer sort;

    @ApiModelProperty("职位描述")
    @TableField("description")
    private String description;

    @ApiModelProperty("职位状态(0正常 1停用)")
    @TableField("status")
    private Integer status;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("创建人ID")
    @TableField("create_by")
    private Long createBy;

    @ApiModelProperty("修改时间")
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    @TableField("update_by")
    private Long updateBy;

    @ApiModelProperty("删除标志(true删除 false未删除)")
    @TableField("delete_flag")
    @TableLogic
    private Boolean deleteFlag;
}
