package com.jk.controller.conllect;

import com.jk.bean.Room;
import com.jk.bean.Shouzhi;
import com.jk.bean.Tenant;
import com.jk.service.collect.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * @ClassName CollectController
 * @Description TODO
 * @Author lenovo
 * @Date 2019/5/7 14:59
 * @ Version 1.0
 */
@Controller
@RequestMapping("collect")
public class CollectController {
       @Autowired
        private CollectService collectService;


    //查询Room待收账单
    @RequestMapping("queryRoom")
    @ResponseBody
    public HashMap<String ,Object> queryRoom(Integer page, Integer rows , Room room){
        return  collectService.queryRoom(page, rows , room);
    }
    //Room确认收款
    @RequestMapping("updateRoom")
    public @ResponseBody String updateRoom(Integer romid){
        collectService.updateRoom(romid);
        return null;
    }

   //查询tenant待支账单
    @RequestMapping("queryTenant")
    @ResponseBody
    public HashMap<String ,Object> queryTenant(Integer page, Integer rows, Tenant tenant){
        return  collectService.queryTenant(page, rows ,tenant);
    }

    //Tenant确认收款
    @RequestMapping("updateTenant")
    public @ResponseBody String updateTenant(Integer teid){
        collectService.updateTenant(teid);
        return null;
    }


    //查询收支流水
    @RequestMapping("queryShouzhi")
    @ResponseBody
    public HashMap<String ,Object> queryShouzhi(Integer page, Integer rows, Shouzhi shouzhi){
        return  collectService.queryShouzhi(page, rows ,shouzhi);
    }


}
