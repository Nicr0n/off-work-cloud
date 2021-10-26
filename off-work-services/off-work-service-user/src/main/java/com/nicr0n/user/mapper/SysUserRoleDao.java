package com.nicr0n.user.mapper;

import com.nicr0n.user.entity.po.SysRole;
import com.nicr0n.user.entity.po.SysUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Nicr0n
 * @since 2021/10/19 13:32
 */
public interface SysUserRoleDao extends BaseMapper<SysUserRole> {
}
