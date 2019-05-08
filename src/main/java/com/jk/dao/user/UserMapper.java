package com.jk.dao.user;


import com.jk.bean.User;

/**
 * <pre>项目名称：
 * 类名称：:${user}
 * 创建人：李健
 * 创建时间：${date}
 * 修改人：李健
 * 修改时间：${time}
 * 修改备注：
 * @version </pre>
 */
public interface UserMapper {

    User findaccount(String name);

    User findemail(String userEmail);

    User findPhone(String loginNumber);

}
