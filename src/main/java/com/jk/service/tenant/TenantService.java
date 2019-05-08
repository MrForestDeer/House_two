package com.jk.service.tenant;

import com.jk.bean.Room;
import com.jk.bean.Tenant;

import java.util.HashMap;

public interface TenantService {
    HashMap<String, Object> queryTenant(Tenant tenant,Integer page, Integer rows);

    HashMap<String, Object> queryRoom(Room room,Integer page, Integer rows);


    Tenant queryTenantById(Integer id);

    Room queryRoomById(Integer id);

    void updateRoom(Room room);

    Room findroombyid(Integer id);

    void addRoom(Room room);

    void addTenant(Tenant tenant);

    void updateTenant(Tenant tenant);

    Tenant findTenantbyid(Integer id);
}
