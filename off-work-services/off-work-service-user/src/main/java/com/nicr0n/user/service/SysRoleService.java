package com.nicr0n.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nicr0n.swagger.entity.vo.PageParam;
import com.nicr0n.user.entity.SysRole;
import com.nicr0n.user.entity.po.SysRoleDTO;
import com.nicr0n.user.entity.vo.SysRoleVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Nicr0n
 * @since 2021/10/19 13:32
 */
public interface SysRoleService extends IService<SysRole> {
	Page<SysRole> getRolesPage(PageParam pageParam);

	SysRoleVO getRoleByID(Long id);

    Boolean updateRoleByRoleID(Long roleID, SysRoleDTO sysRoleDTO);

	Boolean addRole(SysRoleDTO sysRoleAddDTO);
}
