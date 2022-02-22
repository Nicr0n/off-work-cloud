package com.nicr0n.user.service.impl;

import com.nicr0n.user.constants.SystemConstants;
import com.nicr0n.user.entity.SysMenu;
import com.nicr0n.user.entity.vo.MetaVO;
import com.nicr0n.user.entity.vo.RouteItemVO;
import com.nicr0n.user.mapper.SysMenuDao;
import com.nicr0n.user.service.SysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Nicr0n
 * @since 2021/10/19 13:32
 */
@Service
public class SysMenuServiceImp extends ServiceImpl<SysMenuDao, SysMenu> implements SysMenuService {

	@Override
	public List<RouteItemVO> getRouteList() {
		List<SysMenu> sysMenuList = this.list();
		List<RouteItemVO> routeList = menuRecursion(SystemConstants.MENU_ROOT_ID, sysMenuList);
		return routeList;
	}

	/**
	 * 递归生成多级路由列表
	 *
	 * @param parentID
	 * @param sysMenuList
	 * @return
	 */
	private List<RouteItemVO> menuRecursion(Long parentID, List<SysMenu> sysMenuList) {
		List<RouteItemVO> routeList = new ArrayList<>();
		Optional.ofNullable(sysMenuList)
				// 如果存在对象，则筛选出与父ID相同的菜单
				.ifPresent(sysMenus -> sysMenus.stream().filter(menu -> menu.getParentId().equals(parentID))
						.forEach(menu -> {
							RouteItemVO routeItemVO = new RouteItemVO();
							BeanUtils.copyProperties(menu, routeItemVO);
							routeItemVO.setHidden(!menu.getVisibleFlag());
							// 封装额外信息
							MetaVO metaVO = new MetaVO();
							metaVO.setIcon(menu.getIcon());
							metaVO.setNoCache(menu.getCacheFlag());
							metaVO.setTitle(menu.getTitle());
							routeItemVO.setMeta(metaVO);
							// 递归子节点
							routeItemVO.setChildren(menuRecursion(routeItemVO.getMenuId(), sysMenuList));
							// 将节点加入到列表中
							routeList.add(routeItemVO);
						}));
		return routeList;
	}
}
