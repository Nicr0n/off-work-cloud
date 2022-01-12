package com.nicr0n.user.service;

import com.nicr0n.swagger.entity.vo.PageParam;
import com.nicr0n.user.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nicr0n.user.entity.po.RegisterDTO;
import com.nicr0n.user.entity.po.SysUserUpdateDTO;
import com.nicr0n.user.entity.vo.SysUserListPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Nicr0n
 * @since 2021/10/19 13:32
 */
public interface SysUserService extends IService<SysUser> {

    SysUser getUserByUsername(String username);

    SysUser getCurrentUser();

    SysUserListPage getUserList(PageParam pageParam);

    boolean updateByUserID(Long id, SysUserUpdateDTO sysUserUpdateDTO);

	Boolean register(RegisterDTO registerDTO);
}
