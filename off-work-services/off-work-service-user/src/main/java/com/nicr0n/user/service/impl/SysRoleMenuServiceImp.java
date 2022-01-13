package com.nicr0n.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nicr0n.user.entity.SysMenu;
import com.nicr0n.user.entity.SysRoleMenu;
import com.nicr0n.user.mapper.SysMenuDao;
import com.nicr0n.user.mapper.SysRoleMenuDao;
import com.nicr0n.user.service.SysRoleMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Nicr0n
 * @since 2021/10/19 13:32
 */
@Service
public class SysRoleMenuServiceImp extends ServiceImpl<SysRoleMenuDao, SysRoleMenu> implements SysRoleMenuService {

	@Resource
	SysRoleMenuDao roleMenuDao;

	@Resource
	SysMenuDao menuDao;

	@Override
	public List<SysMenu> getMenuListByRoleID(Long id) {
		// 查询角色与菜单的关联
		List<SysRoleMenu> roleMenuList = roleMenuDao.selectList(new QueryWrapper<SysRoleMenu>().eq("role_id", id));
		// 获取角色对应的菜单ID List
		List<Long> menuIDList = roleMenuList.stream().map(SysRoleMenu::getMenuId).collect(Collectors.toList());
		// 按照ID列表查询菜单
		return menuDao.selectBatchIds(menuIDList);
	}
}
