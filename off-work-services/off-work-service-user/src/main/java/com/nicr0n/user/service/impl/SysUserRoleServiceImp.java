package com.nicr0n.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nicr0n.user.entity.SysRole;
import com.nicr0n.user.entity.SysUserRole;
import com.nicr0n.user.mapper.SysUserRoleDao;
import com.nicr0n.user.service.SysRoleService;
import com.nicr0n.user.service.SysUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
public class SysUserRoleServiceImp extends ServiceImpl<SysUserRoleDao, SysUserRole> implements SysUserRoleService {

    @Resource
    SysUserRoleDao userRoleDao;

    @Resource
    SysRoleService roleService;

    @Override
    public List<SysRole> getRolesByUserID(Long userID) {
        // 查询用户角色关联信息
        QueryWrapper<SysUserRole> sysUserRoleQueryWrapper = new QueryWrapper<>();
        sysUserRoleQueryWrapper.eq("user_id", userID);
        List<SysUserRole> sysUserRoleList = userRoleDao.selectList(sysUserRoleQueryWrapper);
        // 获取用户对应的角色ID List
        List<Long> roleIDList = sysUserRoleList.stream().map(SysUserRole::getRoleId).collect(Collectors.toList());
        // 按照ID列表查询role
        return roleService.listByIds(roleIDList);
    }
}
