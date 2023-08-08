package com.jk.controller.manage;

import com.jk.service.manage.MangerServicce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@Controller
public class MangerCoutroller {

@Autowired
MangerServicce mangerServicce;


//点击树 进方法 返回对应页面
    @RequestMapping("getJsp")
    public String getJsp(String uri ){
        return  uri;
    }


    @RequestMapping("findUser")
    @ResponseBody
    public HashMap<String,Object> findUser(Integer start, Integer pageSize){
      return   mangerServicce.findUser(start,pageSize);

    }
    //删除
    @RequestMapping("deleteUser")
    @ResponseBody
    public void deleteUser(String userId){
        mangerServicce.deleteUser( userId);

    }
//查询角色
    @RequestMapping("findRole")
    @ResponseBody
    public HashMap<String,Object> findRoles(Integer start, Integer pageSize){
return  mangerServicce.findRoles(start,pageSize);

    }
    //查询ztree
    @RequestMapping("findMenu")
    @ResponseBody
    public List<LinkedHashMap<String, Object>> findMenu(){

        return mangerServicce.findMenu();

    }



    //修改角色回显 //参数角色id
    @RequestMapping("dindByRoleId")
    public  String dindByRoleId(String rid, Model model){
        List<Integer>list= mangerServicce.dindByRoleId( rid);
        model.addAttribute("rid", rid);
        model.addAttribute("powerList", list);

        return "dialogPowerTree";//修改职位页面
    }

    //修改角色
    @RequestMapping("saveRolePower")
    @ResponseBody                   //powerIds 前台拼接选择的职位或者权限
    public String saveRolePower(Integer rid,String powerIds){

        mangerServicce.saveRolePower( rid, powerIds);
        return null;
    }






}
