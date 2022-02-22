package com.nicr0n.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nicr0n.swagger.entity.vo.PageParam;
import com.nicr0n.user.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nicr0n.user.entity.po.RegisterDTO;
import com.nicr0n.user.entity.po.SysUserDTO;
import com.nicr0n.user.entity.vo.CurrentUserVO;
import com.nicr0n.user.entity.vo.SysUserDetailVO;

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

	CurrentUserVO getCurrentUser();

    Page<SysUser> getUserPage(PageParam pageParam);

    boolean updateByUserID(Long id, SysUserDTO sysUserDTO);

	Boolean register(RegisterDTO registerDTO);

	SysUserDetailVO getUserByID(Long id);
}
