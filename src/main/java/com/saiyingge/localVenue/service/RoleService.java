package com.saiyingge.localVenue.service;


import com.saiyingge.localVenue.entity.Role;

import java.util.List;

public interface RoleService {

    public void saveRole(Role role);
    public Role findRoleByName(String name);

    public List<Role> findRolesByUserId(int id);
}