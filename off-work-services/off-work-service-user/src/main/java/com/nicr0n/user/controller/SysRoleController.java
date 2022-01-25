package com.nicr0n.user.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nicr0n.swagger.entity.vo.PageParam;
import com.nicr0n.swagger.entity.vo.Result;
import com.nicr0n.user.entity.SysRole;
import com.nicr0n.user.entity.po.SysRoleAddDTO;
import com.nicr0n.user.entity.po.SysRoleUpdateDTO;
import com.nicr0n.user.entity.vo.SysRoleVO;
import com.nicr0n.user.service.SysRoleMenuService;
import com.nicr0n.user.service.SysRoleService;
import com.nicr0n.user.service.SysUserRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Nicr0n
 * @since 2021/10/19 13:32
 */
@RestController
@RequestMapping("/api/system/role")
@Api(tags = "角色管理")
@Slf4j
public class SysRoleController {

	@Autowired
	SysRoleService roleService;

	@Autowired
	SysUserRoleService userRoleService;

	@ApiOperation(value = "按照用户ID获取角色列表")
	@ApiImplicitParam(name = "id", value = "用户ID", required = true)
	@GetMapping("/byUserID")
	public Result<List<SysRole>> getRolesByUserID(@RequestParam Long id) {
		log.debug("get roles list by userID:{}", id);
		return Result.judgeObject(userRoleService.getRolesByUserID(id));
	}

	@ApiOperation(value = "列表分页")
	@GetMapping("/page")
	public Result<Page<SysRole>> getRolesPage(@RequestParam @Valid PageParam pageParam) {
		log.debug("get roles page");
		return Result.judgeObject(roleService.getRolesPage(pageParam));
	}

	@ApiOperation(value = "按照ID获取角色详情")
	@GetMapping("/{id}")
	public Result<SysRoleVO> getRoleByRoleID(@PathVariable Long id) {
		log.debug("get role by id:{}", id);
		return Result.judgeObject(roleService.getRoleByID(id));
	}

	@ApiOperation(value = "修改角色信息")
	@PutMapping("/{id}")
	public Result updateRoleByRoleID(@PathVariable Long id, @RequestBody SysRoleUpdateDTO sysRoleUpdateDTO){
		log.debug("update role by id:{}",id);
		return Result.judge(roleService.updateRoleByRoleID(id,sysRoleUpdateDTO),"修改角色信息");
	}

	@ApiOperation(value = "修改角色信息")
	@PostMapping
	public Result addRole(@RequestBody SysRoleAddDTO sysRoleAddDTO){
		log.debug("add new role");
		return Result.judge(roleService.addRole(sysRoleAddDTO),"新增角色");
	}
}

