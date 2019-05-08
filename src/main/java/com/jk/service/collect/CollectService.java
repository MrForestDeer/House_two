package com.jk.service.collect;

import com.jk.bean.Room;
import com.jk.bean.Shouzhi;
import com.jk.bean.Tenant;

import java.util.HashMap;

public interface CollectService {


    HashMap<String, Object> queryTenant(Integer page, Integer rows, Tenant tenant);

    HashMap<String, Object> queryRoom(Integer page, Integer rows, Room room);

    HashMap<String, Object> queryShouzhi(Integer page, Integer rows, Shouzhi shouzhi);

    void updateRoom(Integer romid);

    void updateTenant(Integer teid);
}


