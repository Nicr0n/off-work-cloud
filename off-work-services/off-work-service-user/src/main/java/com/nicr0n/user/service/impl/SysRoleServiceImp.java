package com.nicr0n.user.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nicr0n.swagger.entity.vo.PageParam;
import com.nicr0n.user.entity.SysRole;
import com.nicr0n.user.entity.SysRoleMenu;
import com.nicr0n.user.entity.po.SysRoleDTO;
import com.nicr0n.user.entity.vo.SysRoleVO;
import com.nicr0n.user.mapper.SysRoleDao;
import com.nicr0n.user.service.SysRoleMenuService;
import com.nicr0n.user.service.SysRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

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
public class SysRoleServiceImp extends ServiceImpl<SysRoleDao, SysRole> implements SysRoleService {

    private final SysRoleMenuService roleMenuService;

    @Override
    public Page<SysRole> getRolesPage(PageParam pageParam) {
        // 构造分页类
        Page<SysRole> sysRolePage = new Page<SysRole>(pageParam.getPage(), pageParam.getPerPage());
        // 分页查询
        this.page(sysRolePage,new QueryWrapper<SysRole>().orderByAsc("sort"));
        return sysRolePage;
    }

    @Override
    public SysRoleVO getRoleByID(Long id) {
        SysRoleVO sysRoleVO = new SysRoleVO();
        BeanUtils.copyProperties(this.getById(id), sysRoleVO);
        sysRoleVO.setSysMenuList(roleMenuService.getMenuListByRoleID(id));
        return sysRoleVO;
    }

    @Override
    @Transactional
    public Boolean updateRoleByRoleID(Long roleID, SysRoleDTO sysRoleDTO) {
        try {
            SysRole sysRole = new SysRole();
            BeanUtils.copyProperties(sysRoleDTO, sysRole);
            sysRole.setRoleId(roleID);
            // 菜单ID列表不为空
            if (CollectionUtil.isNotEmpty(sysRoleDTO.getMenuIdList())) {
                // 删除原来的角色-菜单映射关系
                roleMenuService.deleteRoleMenuByRoleID(roleID);

                // 新增角色-菜单映射关系
                List<SysRoleMenu> roleMenuList = new ArrayList<>();
                sysRoleDTO.getMenuIdList().forEach(menuID -> {
                    roleMenuList.add(new SysRoleMenu(roleID, menuID));
                });
                roleMenuService.saveBatch(roleMenuList);
            }
            return this.updateById(sysRole);
        } catch (Exception e) {
            e.printStackTrace();
            // 回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
    }

    @Override
    @Transactional
    public Boolean addRole(SysRoleDTO sysRoleAddDTO) {
        try {
            SysRole sysRole = new SysRole();
            BeanUtils.copyProperties(sysRoleAddDTO, sysRole);
            this.save(sysRole);
            // 菜单ID列表不为空
            if (CollectionUtil.isNotEmpty(sysRoleAddDTO.getMenuIdList())) {
                // 新增角色-菜单映射关系
                List<SysRoleMenu> roleMenuList = new ArrayList<>();
                sysRoleAddDTO.getMenuIdList().forEach(menuID -> {
                    roleMenuList.add(new SysRoleMenu(sysRole.getRoleId(), menuID));
                });
                roleMenuService.saveBatch(roleMenuList);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            // 回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
    }
}
