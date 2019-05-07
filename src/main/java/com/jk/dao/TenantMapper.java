package com.jk.dao;

import com.jk.bean.Room;
import com.jk.bean.Tenant;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TenantMapper {

    int queryCount();

    List<Tenant> queryTenant(@Param("start") int start, @Param("rows") Integer rows,@Param("tename") String tename,@Param("teaddress") String teaddress, @Param("tenstate") Integer tenstate);

    int queryRoomCount();

    List<Room> queryRoom(@Param("start") int start, @Param("rows") Integer rows,@Param("romame") String romame, @Param("romddress") String romddress, @Param("romstate") Integer romstate);
    @Select("select * from p_tenant where teid = #{id}")
    String queryTenantById(Tenant tenant, @Param("id")Integer id);
    @Select("select * from p_room where romid = #{id}")
    String queryRoomById(Room room, @Param("id") Integer id);

    void updateRoom(Room room);
    @Select("select * from p_room where romid =#{id}")
    Room findroombyid(@Param("id") Integer id);

    void addRoom(Room room);

    void addTenant(Tenant tenant);

    void updateTenant(Tenant tenant);
    @Select("select * from p_tenant where teid =#{id}")
    Tenant findTenantbyid(@Param("id") Integer id);
}
