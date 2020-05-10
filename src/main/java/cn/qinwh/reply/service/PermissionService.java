package cn.qinwh.reply.service;


import cn.qinwh.reply.pojo.Permission;
import cn.qinwh.reply.pojo.Role;
import cn.qinwh.reply.pojo.User;

import java.util.List;

public interface PermissionService extends BaseService<Permission> {

    List<Permission> queryPermissionByUser(User user);

    List<Role> queryRoleByUrl(String url);
}
