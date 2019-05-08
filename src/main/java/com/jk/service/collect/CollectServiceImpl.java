package com.jk.service.collect;

import com.jk.bean.Room;
import com.jk.bean.Shouzhi;
import com.jk.bean.Tenant;
import com.jk.dao.collect.CollectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName CollectServiceImpl
 * @Description TODO
 * @Author lenovo
 * @Date 2019/5/7 15:30
 * @ Version 1.0
 */
@Service
public class CollectServiceImpl  implements  CollectService{
    @Resource
    private CollectMapper collectMapper;

    //查询tenant待支账单
    @Override
    public HashMap<String, Object> queryTenant(Integer page, Integer rows, Tenant tenant) {
        HashMap<String, Object> hashMap = new HashMap<>();
        int total=collectMapper.findTenantCount();
        int start=(page-1)*rows;
        List<Tenant> queryTenant = collectMapper.queryTenant(start,rows,tenant);
        hashMap.put("total", total);
        hashMap.put("rows", queryTenant);
        return hashMap;
    }
    //查询Room待支账单
    @Override
    public HashMap<String, Object> queryRoom(Integer page, Integer rows, Room room) {
        HashMap<String, Object> hashMap = new HashMap<>();
        int total=collectMapper.findRoomCount();
        int start=(page-1)*rows;
        List<Room> queryTenant = collectMapper.queryRoom(start,rows,room);
        hashMap.put("total", total);
        hashMap.put("rows", queryTenant);
        return hashMap;
    }
    //查询Shouzhi收支流水
    @Override
    public HashMap<String, Object> queryShouzhi(Integer page, Integer rows, Shouzhi shouzhi) {

        HashMap<String, Object> hashMap = new HashMap<>();
        int total=collectMapper.findShouzhiCount();
        int start=(page-1)*rows;
        List<Shouzhi> queryTenant = collectMapper.queryShouzhi(start,rows,shouzhi);
        hashMap.put("total", total);
        hashMap.put("rows", queryTenant);
        return hashMap;
    }
    //room修改
    @Override
    public void updateRoom(Integer romid) {
        collectMapper.updateRoom(romid);
    }
    //tenant修改
    @Override
    public void updateTenant(Integer teid) {
        collectMapper.updateTenant(teid);
    }
    //room代收更多
    @Override
    public HashMap<String, Object> queryRoomById(Integer romid) {
        return collectMapper.queryRoomById(romid);
    }
    //tencan代收更多
    @Override
    public HashMap<String, Object> queryTenantById(Integer teid) {
        return collectMapper.queryTenantById(teid);
    }
}
