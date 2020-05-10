package cn.qinwh.reply.service.impl;

import cn.qinwh.reply.mapper.*;
import cn.qinwh.reply.pojo.Permission;
import cn.qinwh.reply.pojo.Role;
import cn.qinwh.reply.pojo.RolePermission;
import cn.qinwh.reply.pojo.User;
import cn.qinwh.reply.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: message
 * @description: 班级业务类
 * @author: qinwh
 * @create: 2020-04-26 01:25
 **/
@Service
public class PermissionServiceImpl extends BaseServiceImpl<Permission> implements PermissionService {

    @Autowired
    PermissionMapper permissionMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    UserRoleMapper userRoleMapper;
    @Autowired
    RolePermissionMapper rolePermissionMapper;

    @Override
    public List<Permission> queryPermissionByUser(User user) {
        List<Permission> permissionList = new ArrayList<>();
        int roleId = user.getRoleId();
        RolePermission rolePermissionWhere = new RolePermission();
        rolePermissionWhere.setRoleId(roleId);
        List<RolePermission> rolePermissionList = rolePermissionMapper.select(rolePermissionWhere);
        for (RolePermission temp : rolePermissionList){
            Permission p = permissionMapper.selectByPrimaryKey(temp.getPermissionId());
            permissionList.add(p);

        }
        return permissionList;
    }

    @Override
    public List<Role> queryRoleByUrl(String url) {
        List<Role> roleList = new ArrayList<>();
        Permission where = new Permission();
        where.setUrl(url);
        Permission permission = permissionMapper.selectOne(where);
        if(permission == null){
            return roleList;
        }
        int permissionId = permission.getId();
        RolePermission rolePermissionWhere = new RolePermission();
        rolePermissionWhere.setPermissionId(permissionId);
        List<RolePermission> rolePermissionList = rolePermissionMapper.select(rolePermissionWhere);
        for(RolePermission rp: rolePermissionList){
            Role role = roleMapper.selectByPrimaryKey(rp.getRoleId());
            roleList.add(role);
        }
        System.out.println("aaaaaaaaaaaaaaaaaaa-"+url);
        System.out.println("aaaaaaaaaaaaaaaaaaa-"+permission.getName());
        System.out.println("aaaaaaaaaaaaaaaaaaa-"+roleList.size());
        return roleList;
    }
}
