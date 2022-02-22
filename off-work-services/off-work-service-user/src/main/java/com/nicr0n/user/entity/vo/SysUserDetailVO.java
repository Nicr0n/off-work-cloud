package com.nicr0n.user.entity.vo;

import com.nicr0n.user.entity.SysUser;
import com.nicr0n.user.entity.po.SysUserDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author: Nicr0n
 * @date: 2022/2/22  16:02
 * @email: Nicr0nFF@gmail.com
 */
@ApiModel(value = "用户详情VO")
@Data
@ToString
public class SysUserDetailVO extends SysUser {

	@ApiModelProperty(value = "角色ID列表")
	private List<Long> roleIDList;
}
