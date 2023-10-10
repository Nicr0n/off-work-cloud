package com.nicr0n.user.controller;


import com.nicr0n.swagger.entity.vo.Result;
import com.nicr0n.user.entity.vo.RouteItemVO;
import com.nicr0n.user.service.SysMenuService;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Nicr0n
 * @since 2021/10/19 13:32
 */
@Tag(name = "菜单管理")
@RestController
@RequestMapping("/api/system/menu")
@RequiredArgsConstructor
@Slf4j
public class SysMenuController {

	private final SysMenuService sysMenuService;

	@Schema(description = "获取多级路由")
	@GetMapping("/routes")
	public Result<List<RouteItemVO>> getRouteList(){
		log.debug("获取多级路由菜单");
		return Result.judgeObject(sysMenuService.getRouteList());
	}

}

