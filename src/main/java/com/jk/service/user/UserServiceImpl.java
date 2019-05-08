package com.jk.service.user;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jk.bean.user.UserBean;
import com.jk.dao.user.UserMapper;
import com.jk.util.HttpClientUtil;
import com.jk.util.Md5Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
  <pre>项目名称：
 * 类名称：:UserServiceImpl
 * 创建人：李健
 * 创建时间：2019/5/7
 * 修改人：李健
 * 修改时间：16:01
 * 修改备注：
 * @version </pre>
*/
@Service
public class UserServiceImpl implements UserService{
    @Resource
    UserMapper mapper;
    @Autowired
    RedisTemplate redisTemplate;

    //邮箱需要
    @Resource
    JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    String from;

    //登录判断
    @Override
    public HashMap<String, Object> login(UserBean ubean, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();

        HttpSession session = request.getSession();


        //在判断账号，因为要先根据前台传的账号去数据库取到相关信息
        UserBean userinfo=mapper.findaccount(ubean.getName());

        if(userinfo==null) {
            result.put("code",2);
            result.put("msg","账号不存在");
            return result;
        }

        //判断前台密码和数据库密码是否一致
        //前台传过来的密码
        String password1 = ubean.getPaword();
        //然后在把前台传过来的密码进行加密和数据库的密码比对
        String md516 = Md5Util.getMd516(password1);
        if(!userinfo.getPaword().equals(md516)) {
            result.put("code",3);
            result.put("msg","密码错误");
            return result;
        }
        //以上都对，那么就将数据（数据库查询出来的）存到Session中去，就可以通过session的值判断是否登录了
        session.setAttribute(session.getId(),userinfo);
        result.put("code",0);
        result.put("msg","登录成功");
        return result;

    }

    //手机验证码登录
    @Override
    public HashMap<String, Object> phoneLogin(String loginNumber, String messageCode,HttpSession session) {

        HashMap<String, Object> result = new HashMap<>();

        //验证手机号是否存在，
        UserBean findPhone = mapper.findPhone(loginNumber);
        if(findPhone==null) {
            //return "手机号不存在";
            result.put("code",1);
            result.put("msg","手机号不存在");
            return result;

        }
        //验证验证码是否正确
        //判断key 是否存在(缓存redis)，ket 在获取验证码时创建
        String key="messCode"+loginNumber;
        if(!redisTemplate.hasKey(key)) {//hasKey:判断key 是否存在
            //return "验证码错误";
            result.put("code",2);
            result.put("msg","验证码错误");
            return result;

        }
        int code = (int) redisTemplate.opsForValue().get(key);
        String valueOf = String.valueOf(code);
        if(!messageCode.equals(valueOf)) {
            //return "验证码错误";

            result.put("code",3);
            result.put("msg","验证码错误");
            return result;
        }

        //登陆成功 则把信息存放到session里
        session.setAttribute(session.getId(), findPhone);
        redisTemplate.delete(key);
        //return "登陆成功";

        result.put("code",0);
        result.put("msg","登陆成功");
        return result;
    }

    //获取短信验证码
    @Override
    public HashMap<String, Object> getPhoneID(String phoneID) {
        HashMap<String, Object> result = new HashMap<>();
        //验证手机号是否存在，
        UserBean findaccount = mapper.findPhone(phoneID);
        if(findaccount==null) {
            //return "手机号不存在";
            result.put("code",1);  //状态码 可自定义
            result.put("msg","手机号不在");// 登录状态信息
            return result;
        }
        //在发送短信
        String url ="https://api.miaodiyun.com/20150822/industrySMS/sendSMS";
        HashMap<String, Object> params =new HashMap<String, Object>();
        HttpClientUtil.post(url, params);
        String accountSid="b8b9e71b593d46a7a726b4934441bba7";
        //账号  1
        params.put("accountSid", accountSid);
        //发送格式  （模板ID）
        params.put("templateid","1461093854");//1116707112
        //6位验证码模板中的信息
        int code = (int) Math.ceil(Math.random()*899999+100000);
        System.out.println("验证码为"+code);
        params.put("param", code); //随机验证码
        //手机号
        params.put("to", phoneID);//手机号

        //转化为规定格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        //获取本地时间
        String format = simpleDateFormat.format(new Date());

        //把时间戳传过去  2
        params.put("timestamp", format);
        //token     3   DD 2ce6e5113b914efb9e37c975ad0f5849    我：b6ed6de471be445498168bce269874e4
        String toben="2ce6e5113b914efb9e37c975ad0f5849";
        //模板签名   1+2+3
        String md532 = Md5Util.getMd532(accountSid+toben+format);

        //签名传过去
        params.put("sig", md532);
        //发送短信
        String returstr = HttpClientUtil.post(url, params);
        JSONObject parseObject = JSON.parseObject(returstr);
        //获取状态吗
        String respcode = parseObject.getString("respCode");
		/*  开启后需要企业认证
		if(!respcode.equals("00000")) {
			 //return "发送短信失败";
			 result.put("code",2);
				result.put("msg","发送短信失败");
				return result;
		}*/
        //存验证码 （因为手机验证码登录时需要对比获取到的验证码，所要先存起来然登录时在取）
        String key="messCode"+phoneID;
        redisTemplate.opsForValue().set(key,code ,5, TimeUnit.MINUTES);

        //return "发送成功";
        result.put("code",0);
        result.put("msg","发送成功");
        return result;
    }

    //发送普通邮件
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public void sendSimpleMail(String to, String title, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(title);
        message.setText(content);
        mailSender.send(message);
        logger.info("邮件发送成功");
    }

    //验证邮箱验证码
    @Override
    public HashMap<String, Object> emailID(String userEmail, String messageCode, HttpSession session) {
        HashMap<String, Object> result = new HashMap<>();

        //验证邮箱号是否存在，
        UserBean findemail = mapper.findemail(userEmail);
        if (findemail == null) {
            result.put("code", 1);
            result.put("msg", "邮箱号不存在");
            return result;

        }
        //验证验证码是否正确
        //判断key 是否存在(缓存redis)，ket 在获取验证码时创建
        String key = "email" + userEmail;
        if (!redisTemplate.hasKey(key)) {//hasKey:判断key 是否存在
            result.put("code", 2);
            result.put("msg", "邮箱验证码错误");
            return result;

        }
        String code = (String) redisTemplate.opsForValue().get(key);
        String valueOf = String.valueOf(code);
        if (!messageCode.equals(valueOf)) {
            result.put("code", 3);
            result.put("msg", "邮箱验证码错误");
            return result;
        }

        //登陆成功 则把信息存放到session里
        session.setAttribute(session.getId(), findemail);
        redisTemplate.delete(key);
        //return "登陆成功";
        result.put("code", 0);
        result.put("msg", "登陆成功");
        return result;
    }
}
