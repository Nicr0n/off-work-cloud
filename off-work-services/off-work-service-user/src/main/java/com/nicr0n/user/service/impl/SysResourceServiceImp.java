package com.nicr0n.user.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nicr0n.swagger.entity.vo.PageParam;
import com.nicr0n.user.entity.SysResource;
import com.nicr0n.user.entity.po.SysResourceDTO;
import com.nicr0n.user.mapper.SysResourceDao;
import com.nicr0n.user.service.SysResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Nicr0n
 * @since 2022/01/26 13:58
 */
@Service
public class SysResourceServiceImp extends ServiceImpl<SysResourceDao, SysResource> implements SysResourceService {

	@Override
	public Page<SysResource> getResourcePage(PageParam pageParam) {
		Page<SysResource> resourcePage = new Page<>(pageParam.getPage(), pageParam.getPerPage());
		return this.page(resourcePage);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean addResource(SysResourceDTO sysResourceDTO) {
		// 拷贝属性
		SysResource sysResource = new SysResource();
		BeanUtils.copyProperties(sysResourceDTO, sysResource);
		return this.save(sysResource);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean updateResource(Long id, SysResourceDTO sysResourceDTO) {
		// 拷贝属性
		SysResource sysResource = new SysResource();
		BeanUtils.copyProperties(sysResourceDTO, sysResource);
		sysResource.setResourceId(id);
		return this.updateById(sysResource);
	}
}
