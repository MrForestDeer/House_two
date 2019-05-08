package com.jk.dao.tenant;

import com.jk.bean.Room;
import com.jk.bean.Tenant;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

public interface TenantMapper {

    int queryCount();

    List<Tenant> queryTenant(@Param("start") int start, @Param("rows") Integer rows,@Param("tename") String tename,@Param("teaddress") String teaddress, @Param("tenstate") Integer tenstate);
    int queryRoomCount();
    List<Room> queryRoom(@Param("start") int start, @Param("rows") Integer rows,@Param("romame") String romame, @Param("romddress") String romddress, @Param("romstate") Integer romstate);
    void updateRoom(Room room);

    void addRoom(Room room);

    void addTenant(Tenant tenant);

    void updateTenant(Tenant tenant);
    @Select("select * from p_room where romid =#{id}")
    Room findroombyid(@Param("id") Integer id);
    @Select("select * from p_tenant where teid =#{id}")
    Tenant findTenantbyid(@Param("id") Integer id);
    @Select("select * from p_tenant where teid = #{id}")
    HashMap<String, Object> queryTenantById(Integer id);
    @Select("select * from p_room where romid = #{id}")
    HashMap<String, Object> queryRoomById(Integer id);
}
