package com.nicr0n.user.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author: Nicr0n
 * @date: 2022/2/17  8:33
 * @email: Nicr0nFF@gmail.com
 */
@Data
@Schema(description = "当前用户VO")
public class CurrentUserVO {
	@Schema(description = "id")
	@TableId(value = "user_id", type = IdType.AUTO)
	private Long userId;

	@Schema(description = "昵称")
	@TableField("nick_name")
	private String nickName;

	@Schema(description = "头像url")
	@TableField("avatar_url")
	private String avatarUrl;

	@Schema(description = "性别")
	@TableField("gender")
	private Integer gender;

	@Schema(description = "上次登录IP地址")
	@TableField("last_login_ip")
	private String lastLoginIp;

	@Schema(description = "上次登录时间")
	@TableField("last_login_time")
	private Date lastLoginTime;

	@Schema(description = "角色列表")
	private List<String> roles;


}
