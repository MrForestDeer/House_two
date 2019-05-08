package com.jk.dao.collect;

import com.jk.bean.Room;
import com.jk.bean.Shouzhi;
import com.jk.bean.Tenant;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName CollectMapper
 * @Description TODO
 * @Author lenovo
 * @Date 2019/5/7 15:41
 * @ Version 1.0
 */
public interface CollectMapper {
    //tenant 查询
    int findTenantCount();
    List<Tenant> queryTenant(@Param("start")int start,@Param("rows") Integer rows, Tenant tenant);
    //Room 查询
    int findRoomCount();

    List<Room> queryRoom(@Param("start")int start, @Param("rows")Integer rows, Room room);



    //Shouzhi查询
    List<Shouzhi> queryShouzhi(@Param("start")int start, @Param("rows") Integer rows, Shouzhi shouzhi);

    int findShouzhiCount();
    //room修改
    void updateRoom( @Param("romid")Integer romid);
    //tenant修改
    void updateTenant( @Param("teid") Integer teid);
    //room弹框
    HashMap<String, Object> queryRoomById(Integer romid);
    //tencan弹框
    HashMap<String, Object> queryTenantById(Integer teid);
}
