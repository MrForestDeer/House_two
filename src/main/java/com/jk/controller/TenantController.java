package com.jk.controller;

import com.jk.bean.Room;
import com.jk.bean.Tenant;
import com.jk.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("tenant")
public class TenantController {

    @Autowired
    private TenantService tenantService;

    @RequestMapping("show")
    public String show(){
        return "roomshow";
    }

    //查询租客
    @RequestMapping("queryTenant")
    @ResponseBody
    public HashMap<String,Object> queryTenant(Tenant tenant,Integer page,Integer rows){
        return tenantService.queryTenant(tenant,page,rows);
    }
    //查询租客详情信息
    @RequestMapping("queryTenantById")
    @ResponseBody
    public String queryTenantById(Tenant tenant,Integer id){
        return tenantService.queryTenantById(tenant,id);
    }

    //查询房东
    @RequestMapping("queryRoom")
    @ResponseBody
    public HashMap<String,Object> queryRoom(Room room,Integer page,Integer rows){
        return tenantService.queryRoom(room,page,rows);
    }
    //查询房东详情信息
    @RequestMapping("queryRoomById")
    @ResponseBody
    public String queryRoomById(Room room,Integer id){
        return tenantService.queryRoomById(room,id);
    }
    //完善合同
    //新增
    @ResponseBody
    @RequestMapping("addRoom")
    public String addRoom(Room room){
        tenantService.addRoom(room);
        return null;
    }
    @RequestMapping("addRoom")
    public String addRoom() {
        return "add";
    }
    //修改
    @RequestMapping("updateRoom")
    @ResponseBody
    public void updateRoom(Room room){

        tenantService.updateRoom(room);

    }
    @RequestMapping("findroombyid")
    public String  findroombyid(Integer id, Model model){
        Room room= tenantService.findroombyid(id);
        model.addAttribute("c",room);
        return  "add";
    }

    


}
