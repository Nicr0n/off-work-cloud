package com.nicr0n.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nicr0n.user.entity.po.SysUser;
import com.nicr0n.user.mapper.SysUserDao;
import com.nicr0n.user.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

    @Override
    public SysUser getUserByUsername(String username) {
        SysUser user = this.getOne(new QueryWrapper<SysUser>()
                .eq("username", username)
        );
        return user;
    }
}
