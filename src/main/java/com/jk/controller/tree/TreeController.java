package com.jk.controller.tree;

import com.jk.bean.User;
import com.jk.service.tree.TreeService;
import com.jk.util.MenuTree;

import com.jk.util.TreeNoteUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TreeController {
    @Autowired
    TreeService  treeService;

    @RequestMapping("findPorweTree")
    @ResponseBody
    public List<MenuTree> findPorweTree (HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(session.getId());
        if(user!=null){
            List<MenuTree> list=   treeService.findPorweTree(user.getId());
            list= TreeNoteUtil.getFatherNode(list);
            return  list;
        }

        return null;
    }
}
