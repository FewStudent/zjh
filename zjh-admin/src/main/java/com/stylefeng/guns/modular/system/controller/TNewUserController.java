package com.stylefeng.guns.modular.system.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.shiro.ShiroKit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.TNewUser;
import com.stylefeng.guns.modular.system.service.ITNewUserService;

import java.util.List;

/**
 * 客户总信息管理控制器
 *
 * @author fengshuonan
 * @Date 2019-10-07 16:52:27
 */
@Controller
@RequestMapping("/tNewUser")
public class TNewUserController extends BaseController {

    private String PREFIX = "/new_user/tNewUser/";

    @Autowired
    private ITNewUserService tNewUserService;
    
    /**
     * 跳转到客户总信息管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "tNewUser.html";
    }

    /**
     * 跳转到添加客户总信息管理
     */
    @RequestMapping("/tNewUser_add")
    public String tNewUserAdd() {
        return PREFIX + "tNewUser_add.html";
    }

    /**
     * 跳转到修改客户总信息管理
     */
    @RequestMapping("/tNewUser_update/{tNewUserId}")
    public String tNewUserUpdate(@PathVariable Integer tNewUserId, Model model) {
        TNewUser tNewUser = tNewUserService.selectById(tNewUserId);
        model.addAttribute("item", tNewUser);
        LogObjectHolder.me().set(tNewUser);
        return PREFIX + "tNewUser_edit.html";
    }

    /**
     * 获取客户总信息管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return tNewUserService.selectList(null);
    }

    /**
     * 新增客户总信息管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(TNewUser tNewUser) {
        tNewUserService.insert(tNewUser);
        return SUCCESS_TIP;
    }

    /**
     * 删除客户总信息管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer tNewUserId) {
        tNewUserService.deleteById(tNewUserId);
        return SUCCESS_TIP;
    }

    /**
     * 修改客户总信息管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(TNewUser tNewUser) {
        tNewUserService.updateById(tNewUser);
        return SUCCESS_TIP;
    }

    /**
     * 客户总信息管理详情
     */
    @RequestMapping(value = "/detail/{tNewUserId}")
    @ResponseBody
    public Object detail(@PathVariable("tNewUserId") Integer tNewUserId) {
        return tNewUserService.selectById(tNewUserId);
    }

    @RequestMapping("/test")
    @ResponseBody
    public List<TNewUser> queryAllInfo(){
        if(ShiroKit.getUser().getRoleList().contains(1) || ShiroKit.getUser().getRoleList().contains(10)){
            return tNewUserService.queryByCreateId(null);
        }
        return  tNewUserService.queryByCreateId(ShiroKit.getUser().getId());
    }
}
