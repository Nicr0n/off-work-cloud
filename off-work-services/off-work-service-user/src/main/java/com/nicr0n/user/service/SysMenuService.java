package com.nicr0n.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nicr0n.user.entity.SysMenu;
import com.nicr0n.user.entity.vo.RouteItemVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Nicr0n
 * @since 2021/10/19 13:32
 */
public interface SysMenuService extends IService<SysMenu> {

	List<RouteItemVO> getRouteList();
}
