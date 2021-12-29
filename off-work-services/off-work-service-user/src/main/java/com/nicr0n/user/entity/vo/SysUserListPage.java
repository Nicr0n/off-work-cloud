package com.nicr0n.user.entity.vo;

import com.nicr0n.user.entity.SysUser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: Nicr0n
 * @date: 2021/12/16    16:11
 * @email: Nicr0nFF@gmail.com
 */
@ApiModel("用户列表VO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUserListPage {

    @ApiModelProperty("用户列表")
    List<SysUser> userList;

    @ApiModelProperty("总记录数")
    Long totalRecords;
}
