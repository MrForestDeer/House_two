package com.jk.service.manage;

import com.jk.bean.Role;
import com.jk.bean.User;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public interface MangerServicce {
    HashMap<String,Object> findUser(Integer start, Integer pageSize);


    void deleteUser(String userId);

    HashMap<String,Object> findRoles(Integer start, Integer pageSize);

    List<Integer> dindByRoleId(String rid);

    List<LinkedHashMap<String, Object>> findMenu();

    void saveRolePower(Integer rid, String powerIds);
}
