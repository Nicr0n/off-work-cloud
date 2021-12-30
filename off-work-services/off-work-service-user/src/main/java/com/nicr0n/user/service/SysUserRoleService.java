package com.nicr0n.user.service;

import com.nicr0n.user.entity.SysRole;
import com.nicr0n.user.entity.SysUserRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Nicr0n
 * @since 2021/10/19 13:32
 */
public interface SysUserRoleService extends IService<SysUserRole> {

    /**
     * 按照UserID查询角色列表
     * @param userID 用户ID
     * @return 用户对应的角色列表
     */
    List<SysRole> getRolesByUserID(Long userID);

    /**
     * 按照ID删除用户-角色映射关系
     * @param userID 用户ID
     * @return
     */
    boolean deleteUserRolesByUserID(Long userID);

    /**
     * 按照ID选择性删除用户-角色映射关系
     * @param userID 用户ID
     * @param roleIDList 角色ID列表(需要被删除的)
     * @return
     */
    boolean deleteUserRolesByUserIDSelective(Long userID, List<Long> roleIDList);

}
