package com.nicr0n.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nicr0n.swagger.entity.vo.PageParam;
import com.nicr0n.swagger.entity.vo.Result;
import com.nicr0n.user.entity.SysResource;
import com.nicr0n.user.entity.po.SysResourceDTO;
import com.nicr0n.user.service.SysResourceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Nicr0n
 * @since 2022/01/26 13:58
 */
@Tag(name = "权限管理")
@RestController
@RequestMapping("/api/system/resource")
@Slf4j
public class SysResourceController {

	@Autowired
	SysResourceService sysResourceService;

	@Operation(description = "列表分页")
	@GetMapping("/page")
	@Parameters({
			@Parameter(name = "page", description = "页码", required = true),
			@Parameter(name = "perPage", description = "每页数量", required = true)
	})
	public Result<Page<SysResource>> getResourcesPage(PageParam pageParam) {
		log.debug("get resources page");
		return Result.judgeObject(sysResourceService.getResourcePage(pageParam));
	}

	@Operation(description = "根据菜单列表获取权限列表")
	@GetMapping("/list")
	public Result<List<SysResource>> getResourcesListByMenuID(Long menuID) {
		log.debug("get resources list by menu ID:{}", menuID);
		return Result.judgeObject(sysResourceService.list(new LambdaQueryWrapper<SysResource>().eq(SysResource::getMenuId, menuID)));
	}

	@Operation(description = "获取资源详情")
	@GetMapping("/{id}")
	public Result<SysResource> getResourceByID(@PathVariable Long id) {
		log.debug("get resource by id:{}", id);
		return Result.judgeObject(sysResourceService.getById(id));
	}

	@Operation(description = "新增资源")
	@PostMapping
	public Result addResource(@RequestBody SysResourceDTO sysResourceDTO) {
		log.debug("add new resource with {}", sysResourceDTO);
		return Result.judge(sysResourceService.addResource(sysResourceDTO), "新增资源");
	}

	@Operation(description = "修改资源")
	@PutMapping("/{id}")
	public Result updateResourceByID(@PathVariable Long id, @RequestBody SysResourceDTO sysResourceDTO) {
		log.debug("update resource by id={} with {}", id, sysResourceDTO);
		return Result.judge(sysResourceService.updateResource(id, sysResourceDTO), "修改资源");
	}

	@Operation(description = "删除资源")
	@DeleteMapping()
	public Result deleteResourcesByIDList(@RequestBody List<Long> idList){
		log.debug("delete resources by id list:{}",idList);
		return Result.judge(sysResourceService.removeByIds(idList),"删除资源");
	}
}

