package com.jk.service.manage;

import com.jk.bean.Role;
import com.jk.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;
import java.util.List;

public interface MangerServicce {
    List<User> findUser(Integer start,Integer pageSize);


    void deleteUser(String userId);

    List<Role> findRole( Integer start,  Integer pageSize);

    List<Integer> dindByRoleId(String rid);

    List<LinkedHashMap<String, Object>> findMenu();

    void saveRolePower(Integer rid, String powerIds);
}
