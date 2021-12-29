package com.nicr0n.user.service;

import com.nicr0n.user.entity.SysRole;
import com.nicr0n.user.entity.SysUserRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Nicr0n
 * @since 2021/10/19 13:32
 */
public interface SysUserRoleService extends IService<SysUserRole> {

    List<SysRole> getRolesByUserID(Long userID);

}
