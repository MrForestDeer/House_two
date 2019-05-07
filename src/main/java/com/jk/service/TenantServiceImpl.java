package com.jk.service;

import com.jk.bean.Room;
import com.jk.bean.Tenant;
import com.jk.dao.TenantMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class TenantServiceImpl implements TenantService{

    @Resource
    private TenantMapper tenantMapper;

    @Override
    public HashMap<String, Object> queryTenant(Tenant tenant,Integer page, Integer rows) {
        HashMap<String,Object> hashMap = new HashMap<>();
        int total = tenantMapper.queryCount();
        int start = (page-1)*rows;
        List<Tenant> queyrTenant = tenantMapper.queryTenant(start,rows,tenant.getTename(),tenant.getTeaddress(),tenant.getTenstate());
        hashMap.put("total",total);
        hashMap.put("rows",queyrTenant);
        return hashMap;

    }

    @Override
    public HashMap<String, Object> queryRoom(Room room,Integer page, Integer rows) {
        HashMap<String,Object> hashMap = new HashMap<>();
        int total = tenantMapper.queryRoomCount();
        int start = (page-1)*rows;
        List<Room> queryRoom = tenantMapper.queryRoom(start,rows,room.getRomame(),room.getRomddress(),room.getRomstate());
        hashMap.put("total",total);
        hashMap.put("rows",queryRoom);
        return hashMap;
    }

    @Override
    public String queryTenantById(Tenant tenant, Integer id) {
        return tenantMapper.queryTenantById(tenant, id);
    }
    @Override
    public String queryRoomById(Room room, Integer id) {
        return tenantMapper.queryRoomById(room,id);
    }
    @Override
    public void updateRoom(Room room) {
        tenantMapper.updateRoom(room);
    }
    @Override
    public Room findroombyid(Integer id) {
        return tenantMapper.findroombyid(id);
    }
    @Override
    public void addRoom(Room room) {
        tenantMapper.addRoom(room);
    }
    @Override
    public void addTenant(Tenant tenant) {
        tenantMapper.addTenant(tenant);
    }
    @Override
    public void updateTenant(Tenant tenant) {
        tenantMapper.updateTenant(tenant);

    }
    @Override
    public Tenant findTenantbyid(Integer id) {
        return tenantMapper.findTenantbyid(id);
    }


}
