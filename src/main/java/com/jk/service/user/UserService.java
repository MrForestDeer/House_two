package com.jk.service.user;

import com.jk.bean.user.UserBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
  <pre>项目名称：
 * 类名称：:UserService   
 * 创建人：李健
 * 创建时间：2019/5/7   
 * 修改人：李健
 * 修改时间：16:01
 * 修改备注：       
 * @version </pre>
*/
public interface UserService {

    HashMap<String, Object> login(UserBean ubean, HttpServletRequest request);

    HashMap<String, Object> phoneLogin(String loginNumber, String messageCode, HttpSession session);

    HashMap<String, Object> getPhoneID(String phoneID);

    void sendSimpleMail(String userEmail, String 注册验证码, String message);

    HashMap<String, Object> emailID(String userEmail, String messageCode, HttpSession session);
}
