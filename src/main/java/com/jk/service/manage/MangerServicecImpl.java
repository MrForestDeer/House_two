package com.jk.service.manage;


import com.jk.bean.Role;
import com.jk.bean.User;
import com.jk.dao.HouseMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

public class MangerServicecImpl implements  MangerServicce {
    @Autowired
    HouseMapper mapper;
    @Override
    public List<User> findUser(Integer start,Integer pageSize) {
        return mapper.findUser( start, pageSize);
    }

    @Override
    public void deleteUser(String userId) {
        mapper.deleteUser(userId);
    }

    @Override
    public List<Role> findRole(Integer start,  Integer pageSize) {
        return mapper.findRole(start,pageSize);
    }

    @Override
    public List<Integer> dindByRoleId(String rid) {
        return mapper.dindByRoleId( rid);
    }

    @Override
    public List<LinkedHashMap<String, Object>> findMenu() {
        return mapper.findMenu();
    }

    @Override
    public void saveRolePower(Integer rid, String powerIds) {
        mapper.deleteRolePower(rid);
        String rpid= UUID.randomUUID().toString();
        mapper.addRolePower(rpid,rid,powerIds.split(","));


    }
}
