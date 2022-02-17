package com.nicr0n.user.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.jwt.JWTUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nicr0n.swagger.entity.vo.PageParam;
import com.nicr0n.user.entity.SysRole;
import com.nicr0n.user.entity.SysUser;
import com.nicr0n.user.entity.SysUserRole;
import com.nicr0n.user.entity.po.RegisterDTO;
import com.nicr0n.user.entity.po.SysUserDTO;
import com.nicr0n.user.entity.vo.CurrentUserVO;
import com.nicr0n.user.mapper.SysUserDao;
import com.nicr0n.user.service.SysUserRoleService;
import com.nicr0n.user.service.SysUserService;
import com.nicr0n.user.utils.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Nicr0n
 * @since 2021/10/19 13:32
 */
@Service
@RequiredArgsConstructor
public class SysUserServiceImp extends ServiceImpl<SysUserDao, SysUser> implements SysUserService {

	private final SysUserRoleService userRoleService;

	@Override
	public SysUser getUserByUsername(String username) {
		SysUser user = this.getOne(new QueryWrapper<SysUser>()
				.eq("username", username)
		);
		return user;
	}

	@Override
	public CurrentUserVO getCurrentUser() {
		CurrentUserVO currentUserVO = new CurrentUserVO();
		// 从jwt中获取用户ID
		Long userID = SecurityUtils.getUserID();
		if (userID == null) {
			return null;
		}
		SysUser sysUser = this.getById(userID);
		BeanUtils.copyProperties(sysUser, currentUserVO);
		currentUserVO.setRoles(userRoleService.getRolesByUserID(userID).stream().map(SysRole::getName).collect(Collectors.toList()));
		return currentUserVO;
	}

	@Override
	public Page<SysUser> getUserPage(PageParam pageParam) {
		// 构造分页类
		Page<SysUser> sysUserPage = new Page<>(pageParam.getPage(), pageParam.getPerPage());
		// 分页查询
		this.page(sysUserPage);
		return sysUserPage;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean updateByUserID(Long id, SysUserDTO sysUserDTO) {
		// 拷贝属性
		SysUser sysUser = new SysUser();
		BeanUtils.copyProperties(sysUserDTO, sysUser);
		sysUser.setUserId(id);

		// 角色ID列表不为空
		if (CollectionUtil.isNotEmpty(sysUserDTO.getRoleIDList())) {
			// 删除原来的用户-角色映射关系
			userRoleService.deleteUserRolesByUserID(id);

			// 新增角色关系
			List<SysUserRole> sysUserRoleList = new ArrayList<>();
			sysUserDTO.getRoleIDList().forEach(roleID -> {
				sysUserRoleList.add(new SysUserRole(id, roleID));
			});
			userRoleService.saveBatch(sysUserRoleList);
		}

		return this.updateById(sysUser);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean register(RegisterDTO registerDTO) {
		SysUser sysUser = new SysUser();
		BeanUtils.copyProperties(registerDTO, sysUser);
		sysUser.setPassword(new BCryptPasswordEncoder().encode(registerDTO.getPassword()));
		return this.save(sysUser);
	}
}
