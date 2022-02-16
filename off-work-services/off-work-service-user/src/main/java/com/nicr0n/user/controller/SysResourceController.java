package com.nicr0n.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nicr0n.swagger.entity.vo.PageParam;
import com.nicr0n.swagger.entity.vo.Result;
import com.nicr0n.user.entity.SysResource;
import com.nicr0n.user.service.SysResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Nicr0n
 * @since 2022/01/26 13:58
 */
@Api(tags = "权限管理")
@RestController
@RequestMapping("/api/system/resource")
@Slf4j
public class SysResourceController {

	@Autowired
	SysResourceService sysResourceService;

	@ApiOperation(value = "列表分页")
	@GetMapping("/page")
	public Result<Page<SysResource>> getResourcesPage(PageParam pageParam) {
		log.debug("get resources page");
		return Result.judgeObject(sysResourceService.getResourcePage(pageParam));
	}

	@ApiOperation(value = "根据菜单列表获取权限列表")
	@GetMapping("/list")
	public Result<List<SysResource>> getResourcesListByMenuID(Long menuID) {
		log.debug("get resources list by menu ID:{}", menuID);
		return Result.judgeObject(sysResourceService.list(new LambdaQueryWrapper<SysResource>().eq(SysResource::getMenuId, menuID)));
	}

}

