package com.jk.controller.user;

import com.jk.bean.User;
import com.jk.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
  <pre>项目名称：
 * 类名称：:UserController
 * 创建人：李健
 * 创建时间：2019/5/7
 * 修改人：李健
 * 修改时间：15:51
 * 修改备注：
 * @version </pre>
*/
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    RedisTemplate redisTemplate;
    //登录判断(账号密码)
    @RequestMapping("login")
    @ResponseBody                                                        //取图片里的数字码 在Session里 所以创建session
    public HashMap<String,Object> login(User ubean, HttpServletRequest request){

        return userService.login(ubean,request);
    }

    //手机验证码登录
    @RequestMapping("phoneLogin")
    @ResponseBody
    public HashMap<String,Object> phoneLogin(String loginNumber,String messageCode , HttpSession session) {
        return userService.phoneLogin(loginNumber,messageCode,session);
    }

    //获取手机验证码
    @RequestMapping("getPhoneID")
    @ResponseBody
    public HashMap<String,Object> getPhoneID(String phoneID) {
        HashMap<String,Object> ss= userService.getPhoneID(phoneID);
        return ss;
    }

    //邮箱验证码验证
    @RequestMapping("emailID")
    @ResponseBody
    public HashMap<String,Object> emailID(String userEmail,String messageCode , HttpSession session) {
        return userService.emailID(userEmail,messageCode,session);
    }

    //获取邮箱验证码
    @RequestMapping("getCheckCode")
    @ResponseBody
    public String getCheckCode(String userEmail, HttpServletRequest HttpServletRequest){
        String checkCode = String.valueOf(new Random().nextInt(899999) + 100000);
        System.out.println("邮箱验证码"+checkCode);
        String key="email"+userEmail;
        redisTemplate.opsForValue().set(key,checkCode ,3, TimeUnit.MINUTES);
        String message = "商品用户注册验证码为："+checkCode+"验证码时效为三分钟";
        try {
            userService.sendSimpleMail(userEmail, "注册验证码", message);
        }catch (Exception e){
            return "";
        }
        HttpServletRequest.getSession().setAttribute("checkCode",checkCode);
        return checkCode;
    }


    @RequestMapping("page")
    public String page(){
        return "AAA";
    }
}
