package com.nicr0n.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nicr0n.user.entity.SysRole;
import com.nicr0n.user.entity.SysUserRole;
import com.nicr0n.user.mapper.SysRoleDao;
import com.nicr0n.user.mapper.SysUserRoleDao;
import com.nicr0n.user.service.SysUserRoleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

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
    SysRoleDao roleDao;

    @Override
    public List<SysRole> getRolesByUserID(Long userID) {
        // 查询用户角色关联信息
        List<SysUserRole> sysUserRoleList = userRoleDao.selectList(new QueryWrapper<SysUserRole>().eq("user_id", userID));
        // 获取用户对应的角色ID List
        List<Long> roleIDList = sysUserRoleList.stream().map(SysUserRole::getRoleId).collect(Collectors.toList());
        // 按照ID列表查询role
        return roleDao.selectBatchIds(roleIDList);
    }

    @Override
    public boolean deleteUserRolesByUserID(Long userID) {
        return this.remove(new QueryWrapper<SysUserRole>().eq("user_id", userID));
    }

    @Override
    public boolean deleteUserRolesByUserIDSelective(Long userID, List<Long> roleIDList) {
        return this.remove(new QueryWrapper<SysUserRole>().eq("user_id", userID).in("role_id", roleIDList));
    }
}
