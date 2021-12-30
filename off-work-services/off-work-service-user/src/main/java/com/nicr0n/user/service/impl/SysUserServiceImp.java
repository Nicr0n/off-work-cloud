package com.nicr0n.user.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nicr0n.swagger.entity.vo.PageParam;
import com.nicr0n.user.entity.SysUser;
import com.nicr0n.user.entity.SysUserRole;
import com.nicr0n.user.entity.po.SysUserUpdateDTO;
import com.nicr0n.user.entity.vo.SysUserListPage;
import com.nicr0n.user.mapper.SysUserDao;
import com.nicr0n.user.service.SysUserRoleService;
import com.nicr0n.user.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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

    @Resource
    SysUserDao userDao;

    private final SysUserRoleService sysUserRoleService;

    @Override
    public SysUser getUserByUsername(String username) {
        SysUser user = this.getOne(new QueryWrapper<SysUser>()
                .eq("username", username)
        );
        return user;
    }

    @Override
    public SysUser getCurrentUser() {
        return null;
    }

    @Override
    public SysUserListPage getUserList(PageParam pageParam) {
        // 构造分页类
        Page<SysUser> sysUserPage = new Page<>(pageParam.getPage(), pageParam.getPerPage());
        // 分页查询
        this.page(sysUserPage);

        return new SysUserListPage(sysUserPage.getRecords(), sysUserPage.getTotal());
    }

    @Override
    public boolean updateByUserID(Long id, SysUserUpdateDTO sysUserUpdateDTO) {
        // 拷贝属性
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(sysUserUpdateDTO, sysUser);
        sysUser.setUserId(id);

        // 角色ID列表不为空
        if (CollectionUtil.isNotEmpty(sysUserUpdateDTO.getRoleIDList())) {
            // 删除原来的用户-角色映射关系
            sysUserRoleService.deleteUserRolesByUserID(id);

            // 新增角色关系
            List<SysUserRole> sysUserRoleList = new ArrayList<>();
            sysUserUpdateDTO.getRoleIDList().forEach(roleID -> {
                sysUserRoleList.add(new SysUserRole(id, roleID));
            });
            sysUserRoleService.saveBatch(sysUserRoleList);
        }

        return this.updateById(sysUser);
    }
}
