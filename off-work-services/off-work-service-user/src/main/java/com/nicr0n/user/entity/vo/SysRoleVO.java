package com.nicr0n.user.entity.vo;

import com.baomidou.mybatisplus.annotation.*;
import com.nicr0n.db.handler.TimestamptzTypeHandler;
import com.nicr0n.user.entity.SysMenu;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: Nicr0n
 * @date: 2022/1/14  0:29
 * @email: Nicr0nFF@gmail.com
 */
@Data
@Schema(description = "角色详情VO")
public class SysRoleVO {
	@Schema(description = "角色ID")
	@TableId(value = "role_id", type = IdType.AUTO)
	private Long roleId;

	@Schema(description = "角色名称")
	@TableField(value = "name")
	private String name;

	@Schema(description = "角色权限code")
	@TableField("code")
	private String code;

	@Schema(description = "角色排序")
	@TableField("sort")
	private Integer sort;

	@Schema(description = "角色数据作用域")
	@TableField("scope")
	private Integer scope;

	@Schema(description = "角色描述")
	@TableField("description")
	private String description;

	@Schema(description = "角色状态（0正常 1停用)")
	@TableField("status")
	private Integer status;

	@Schema(description = "删除标志(true删除 false未删除)")
	@TableField("delete_flag")
	@TableLogic(value = "false",delval = "true")
	private Boolean deleteFlag;

	@Schema(description = "创建时间")
	@TableField(value = "create_time", fill = FieldFill.INSERT,typeHandler = TimestamptzTypeHandler.class)
	private LocalDateTime createTime;

	@Schema(description = "创建人ID((为NULL则是系统创建))")
	@TableField("create_by")
	private Long createBy;

	@Schema(description = "修改时间")
	@TableField(value = "update_time", fill = FieldFill.UPDATE,typeHandler = TimestamptzTypeHandler.class)
	private LocalDateTime updateTime;

	@Schema(description = "修改人ID(为NULL则是系统创建)")
	@TableField("update_by")
	private Long updateBy;

	@Schema(description = "角色拥有的菜单列表")
	private List<SysMenu> sysMenuList;
}
