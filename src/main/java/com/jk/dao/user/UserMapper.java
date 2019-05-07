package com.jk.dao.user;

import com.jk.bean.user.UserBean;

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

    UserBean findaccount(String name);

    UserBean findemail(String userEmail);

    UserBean findPhone(String loginNumber);

}
