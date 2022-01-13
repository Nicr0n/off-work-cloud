package com.nicr0n.user.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nicr0n.swagger.entity.vo.PageParam;
import com.nicr0n.user.entity.SysRole;
import com.nicr0n.user.entity.vo.SysRoleVO;
import com.nicr0n.user.mapper.SysRoleDao;
import com.nicr0n.user.service.SysRoleMenuService;
import com.nicr0n.user.service.SysRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Nicr0n
 * @since 2021/10/19 13:32
 */
@Service
public class SysRoleServiceImp extends ServiceImpl<SysRoleDao, SysRole> implements SysRoleService {

	@Autowired
	SysRoleMenuService roleMenuService;

	@Override
	public Page<SysRole> getRolesPage(PageParam pageParam) {
		// 构造分页类
		Page<SysRole> sysRolePage = new Page<SysRole>(pageParam.getPage(), pageParam.getPerPage());
		// 分页查询
		this.page(sysRolePage);
		return sysRolePage;
	}

	@Override
	public SysRoleVO getRoleByID(Long id) {
		SysRoleVO sysRoleVO = new SysRoleVO();
		BeanUtils.copyProperties(this.getById(id),sysRoleVO);
		sysRoleVO.setSysMenuList(roleMenuService.getMenuListByRoleID(id));
		return sysRoleVO;
	}
}
