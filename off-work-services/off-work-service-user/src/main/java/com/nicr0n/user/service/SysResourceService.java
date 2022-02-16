package com.nicr0n.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nicr0n.swagger.entity.vo.PageParam;
import com.nicr0n.user.entity.SysResource;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nicr0n.user.entity.po.SysResourceDTO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Nicr0n
 * @since 2022/01/26 13:58
 */
public interface SysResourceService extends IService<SysResource> {

	Page<SysResource> getResourcePage(PageParam pageParam);

	Boolean addResource(SysResourceDTO sysResourceDTO);

	Boolean updateResource(Long id, SysResourceDTO sysResourceDTO);
}
