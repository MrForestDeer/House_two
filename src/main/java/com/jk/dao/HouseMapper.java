package com.jk.dao;

import com.jk.util.MenuTree;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HouseMapper {


    List<MenuTree> findPorweTree(@Param("userid") String id);
}
