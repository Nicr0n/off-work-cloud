package com.nicr0n.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nicr0n.swagger.entity.vo.PageParam;
import com.nicr0n.user.entity.po.SysUser;
import com.nicr0n.user.entity.vo.SysUserListPage;
import com.nicr0n.user.mapper.SysUserDao;
import com.nicr0n.user.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
public class SysUserServiceImp extends ServiceImpl<SysUserDao, SysUser> implements SysUserService {

    @Resource
    SysUserDao userDao;

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
        Page<SysUser> sysUserPage = new Page<>(pageParam.getPage(),pageParam.getPerPage());
        // 分页查询
        this.page(sysUserPage);

        return new SysUserListPage(sysUserPage.getRecords(),sysUserPage.getTotal());
    }
}
