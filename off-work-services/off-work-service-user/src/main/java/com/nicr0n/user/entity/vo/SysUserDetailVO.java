package com.nicr0n.user.entity.vo;

import com.nicr0n.user.entity.SysUser;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author: Nicr0n
 * @date: 2022/2/22  16:02
 * @email: Nicr0nFF@gmail.com
 */
@Schema(description = "用户详情VO")
@Data
@ToString
public class SysUserDetailVO extends SysUser {

	@Schema(description = "角色ID列表")
	private List<Long> roleIDList;
}
