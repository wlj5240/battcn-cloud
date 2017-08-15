package com.battcn.service;

import com.battcn.pojo.UserInfo;
import com.battcn.pojo.UserRole;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Levin
 * @date 2017-08-15.
 */
@Service
public class UserRoleService {

    public List<UserRole> getRoleByUser(UserInfo user) {
        if("test".equals(user.getUserName())) {
            return Lists.newArrayList(new UserRole("ADMIN"));
        }
        return null;
    }
}
