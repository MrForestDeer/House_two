package com.jk.service.manage;


import com.jk.bean.Role;
import com.jk.bean.User;
import com.jk.dao.HouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

@Service
public class MangerServicecImpl implements  MangerServicce {
    @Autowired
    HouseMapper mapper;
    @Override
    public HashMap<String,Object> findUser(Integer start, Integer pageSize) {
        List<User> user = mapper.findUser(start, pageSize);
      Long count=  mapper.findUserCount();
        HashMap<String, Object> map = new HashMap<>();
        map.put("rows",user);
        map.put("total",count);
        return  map;
    }

    @Override
    public void deleteUser(String userId) {
        mapper.deleteUser(userId);
    }
    @Override
    public   HashMap<String,Object>  findRoles(Integer start, Integer pageSize) {
        List<Role> roles = mapper.findRoles(start, pageSize);
        Long count=  mapper.findRolesCount();
        HashMap<String, Object> map = new HashMap<>();
        map.put("rows",roles);
        map.put("total",count);
        return map;
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
