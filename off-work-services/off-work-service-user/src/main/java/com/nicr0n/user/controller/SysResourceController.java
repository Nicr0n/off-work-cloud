package com.nicr0n.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nicr0n.swagger.entity.vo.PageParam;
import com.nicr0n.swagger.entity.vo.Result;
import com.nicr0n.user.entity.SysResource;
import com.nicr0n.user.entity.po.SysResourceDTO;
import com.nicr0n.user.service.SysResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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
@RequestMapping("/system/resource")
@Slf4j
public class SysResourceController {

	@Autowired
	SysResourceService sysResourceService;

	@ApiOperation(value = "列表分页")
	@GetMapping("/page")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "page", value = "页码", required = true),
			@ApiImplicitParam(name = "perPage", value = "每页数量", required = true)
	})
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

	@ApiOperation(value = "获取资源详情")
	@GetMapping("/{id}")
	public Result<SysResource> getResourceByID(@PathVariable Long id) {
		log.debug("get resource by id:{}", id);
		return Result.judgeObject(sysResourceService.getById(id));
	}

	@ApiOperation("新增资源")
	@PostMapping
	public Result addResource(@RequestBody SysResourceDTO sysResourceDTO) {
		log.debug("add new resource with {}", sysResourceDTO);
		return Result.judge(sysResourceService.addResource(sysResourceDTO), "新增资源");
	}

	@ApiOperation("修改资源")
	@PutMapping("/{id}")
	public Result updateResourceByID(@PathVariable Long id, @RequestBody SysResourceDTO sysResourceDTO) {
		log.debug("update resource by id={} with {}", id, sysResourceDTO);
		return Result.judge(sysResourceService.updateResource(id, sysResourceDTO), "修改资源");
	}

	@ApiOperation("删除资源")
	@DeleteMapping()
	public Result deleteResourcesByIDList(@RequestBody List<Long> idList){
		log.debug("delete resources by id list:{}",idList);
		return Result.judge(sysResourceService.removeByIds(idList),"删除资源");
	}
}

