package com.nicr0n.user.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nicr0n.swagger.entity.vo.PageParam;
import com.nicr0n.user.entity.SysResource;
import com.nicr0n.user.mapper.SysResourceDao;
import com.nicr0n.user.service.SysResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
}
