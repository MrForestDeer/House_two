package com.jk.service.tree;

import com.jk.dao.HouseMapper;
import com.jk.util.MenuTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeServiceImpl implements TreeService {

    @Autowired
    HouseMapper houseMapper;
    @Override
    public List<MenuTree> findPorweTree(String id) {
        return houseMapper.findPorweTree(id);
    }
}
