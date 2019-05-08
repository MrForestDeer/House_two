package com.jk.dao;

import com.jk.bean.Role;
import com.jk.bean.User;
import com.jk.util.MenuTree;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

public interface HouseMapper {
    List<MenuTree> findPorweTree(@Param("userid") String id);
    List<User> findUser(@Param("start") Integer start,@Param("pageSize") Integer pageSize);
    @Delete("delete from p_user  where id= #{userId}")
    void deleteUser(@Param("userId") String userId);


    List<Role> findRoles(@Param("start") Integer start,@Param("pageSize") Integer pageSize);

    List<Integer> dindByRoleId(@Param("rid") String rid);

    @Select(" select *from   p_quaninfo")
    List<LinkedHashMap<String, Object>> findMenu();
    @Delete("delete form p_premissions where roid=#{roid}")
    void deleteRolePower(@Param("rid") Integer rid);

    void addRolePower(@Param("rpid")String rpid, @Param("rid")Integer rid,@Param("powerIds") String[] powerIds);

    Long findUserCount();
@Select("select count(*)  from p_role")
    Long findRolesCount();
}
