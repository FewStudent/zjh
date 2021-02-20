package com.stylefeng.guns.modular.system.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.enums.ArrangeType;
import com.stylefeng.guns.core.enums.EndType;
import com.stylefeng.guns.core.enums.PayType;
import com.stylefeng.guns.core.enums.VerifyType;
import com.stylefeng.guns.core.enums.YesOrNo;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.core.util.DateUtil;
import com.stylefeng.guns.modular.system.excel.UserEatExcel;
import com.stylefeng.guns.modular.system.model.TNewUser;
import com.stylefeng.guns.modular.system.model.User;
import com.stylefeng.guns.modular.system.service.IUserService;
import com.stylefeng.guns.modular.system.util.ExcelUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.TUserEat;
import com.stylefeng.guns.modular.system.service.ITNewUserService;
import com.stylefeng.guns.modular.system.service.ITUserEatService;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 控制器
 *
 * @author fengshuonan
 * @Date 2019-09-19 19:03:33
 */
@Controller
@RequestMapping("/tUserEat")
public class TUserEatController extends BaseController {

    private String PREFIX = "/system/tUserEat/";

    @Autowired
    private ITUserEatService tUserEatService;
    @Autowired
    private IUserService iUserService;
    @Autowired
    private ITNewUserService newUserService;

    /**
     * 跳转到首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "tUserEat.html";
    }

    /**
     * 跳转到添加
     */
    @RequestMapping("/tUserEat_add")
    public String tUserEatAdd() {
        return PREFIX + "tUserEat_add.html";
    }

    /**
     * 跳转到修改
     */
    @RequestMapping("/tUserEat_update/{tUserEatId}")
    public String tUserEatUpdate(@PathVariable Integer tUserEatId, Model model) {
        TNewUser tUserEat = newUserService.selectById(tUserEatId);
        model.addAttribute("item", tUserEat);
        LogObjectHolder.me().set(tUserEat);
        return PREFIX + "tUserEat_edit.html";
    }

    /**
     * 跳转到详情
     */
    @RequestMapping("/tUserEat_detail/{tUserEatId}")
    public String tUserEatDetail(@PathVariable Integer tUserEatId, Model model) {
        TNewUser eat = newUserService.queryUserEatById(tUserEatId);
        model.addAttribute("item", eat);
        LogObjectHolder.me().set(eat);
        return PREFIX + "tUserEat_detail.html";
    }

    /**
     * 获取列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String filed1, String value1, String filed2, String value2, Integer status, Integer end) {
        if (status != null && status.intValue() == -1) {
            status = null;
        }
        if (end != null && end.intValue() == -1) {
            end = null;
        }
        // 判断是否是录入员，如果是录入员 只能看到自己录入的信息
        List<TNewUser> userEats;
        if (!ShiroKit.getUser().getRoleList().contains(6)) {
            userEats = newUserService.queryUserEatByFiled(filed1, value1, filed2, value2, status, end, null);
        } else {
            userEats = newUserService.queryUserEatByFiled(filed1, value1, filed2, value2, status, end, ShiroKit.getUser().getId());
        }
        for (TNewUser eat : userEats) {
            // 付费方式
            eat.setEatPayTypeName(PayType.getTypeByIndex(eat.getEatPayType()));
            // 审核状态
            eat.setEatStatusName(VerifyType.getTypeByIndex(eat.getEatStatus()));
            // 结束状态
            eat.setEatEndName(EndType.getTypeByIndex(eat.getEatEnd()));
            //是否晚餐
            eat.setEatDinnerName(YesOrNo.getTypeByIndex(eat.getEatDinner()));
            //安排状态
            eat.setEatArrangeName(ArrangeType.getTypeByIndex(eat.getEatArrange()));
        }
        return userEats;
    }

    /**
     * 新增
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(TUserEat tUserEat) {
        tUserEat.setCreateTime(DateUtil.getTime());
        tUserEat.setStatus(0);
        tUserEat.setEnd(0);
        tUserEatService.insert(tUserEat);
        return SUCCESS_TIP;
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer tUserEatId) {
        newUserService.deleteById(tUserEatId);
        return SUCCESS_TIP;
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(TNewUser tUserEat) {
        tUserEat.setUpdateTime(DateUtil.getTime());
        newUserService.updateById(tUserEat);
        return SUCCESS_TIP;
    }

    /**
     * 详情
     */
    @RequestMapping(value = "/detail/{tUserEatId}")
    @ResponseBody
    public Object detail(@PathVariable("tUserEatId") Integer tUserEatId) {
        return newUserService.queryUserEatById(tUserEatId);
    }

    /**
     * 审核页面
     *
     * @param tUserEatId
     * @return
     */
    @RequestMapping(value = "/examine/{tUserEatId}")
    public String examine_html(@PathVariable("tUserEatId") Integer tUserEatId, Model model) {
        TNewUser newUser = newUserService.queryUserEatById(tUserEatId);
        model.addAttribute("id", tUserEatId);
        model.addAttribute("item", newUser);
        return PREFIX + "tUserEat_examine.html";
    }

    /**
     * 审核
     *
     * @param id
     * @param status
     * @param sRemarkName
     * @param sRemarkContent
     * @return
     */
    @RequestMapping(value = "/examine_do")
    @ResponseBody
    public Object examine_do(Integer id, Integer status, String sRemarkName, String sRemarkContent) {
        TNewUser newUser = this.newUserService.queryUserEatById(id);
        newUser.setEatStatus(status);
        newUser.setEatStatusRemark(sRemarkContent);
        newUser.setEatStatusReamrkName(sRemarkName);
        this.newUserService.updateById(newUser);
        return SUCCESS_TIP;
    }

    /**
     * 安排页面
     *
     * @param tUserEatId
     * @return
     */
    @RequestMapping(value = "/make/{tUserEatId}")
    public String make(@PathVariable("tUserEatId") Integer tUserEatId, Model model) {
        TNewUser newUser = newUserService.queryUserEatById(tUserEatId);
        model.addAttribute("id", tUserEatId);
        model.addAttribute("item", newUser);
        return PREFIX + "tUserEat_make.html";
    }

    /**
     * 安排
     *
     * @param id
     * @param restaurantAttention
     * @return
     */
    @RequestMapping(value = "/make_do")
    @ResponseBody
    public Object make_do(Integer id,Integer arrange, String restaurant, String restaurantDate, Integer restaurantPeoples, String restaurantAttention) {
        TNewUser newUser = this.newUserService.queryUserEatById(id);
        newUser.setEatArrange(arrange);
        newUser.setEatArrangeRemark(restaurantAttention);
        this.newUserService.updateById(newUser);
        return SUCCESS_TIP;
    }

    /**
     * 结束页面
     *
     * @param tUserEatId
     * @param model
     * @return
     */
    @RequestMapping("/end/{tUserEatId}")
    public String end_html(@PathVariable("tUserEatId") Integer tUserEatId, Model model) {
        TNewUser newUser = newUserService.queryUserEatById(tUserEatId);
        model.addAttribute("id", tUserEatId);
        model.addAttribute("item", newUser);
        return PREFIX + "tUserEat_end.html";
    }

    /**
     * 结束
     *
     * @param id
     * @param end
     * @param eRemarkName
     * @param eRemarkContent
     * @return
     */
    @RequestMapping(value = "/end_do")
    @ResponseBody
    public Object end(Integer id, Integer end, String eRemarkName, String eRemarkContent) {
        TNewUser newUser = this.newUserService.queryUserEatById(id);
        newUser.setEatEnd(end);
        newUser.setEatEndRemark(eRemarkName);
        newUser.setEatEndRemarkName(eRemarkContent);
        this.newUserService.updateById(newUser);

        return SUCCESS_TIP;
    }

    /**
     * 导出
     *
     * @return
     */
    @RequestMapping(value = "/exclude")
    public void exclude(HttpServletResponse response) {
        // 判断是否是录入员，如果是录入员 只能看到自己录入的信息
        Integer adminId = ShiroKit.getUser().getId();
        User user = this.iUserService.selectById(adminId);
        List<TNewUser> users = new ArrayList<>();
        String roleid = user.getRoleid();
        if (roleid.contains("6")) {
            Map<String, Object> params = new HashMap<>();
            params.put("create_by", adminId);
            users = this.newUserService.selectByMap(params);
        } else {
            users = this.newUserService.selectList(null);
        }
        List<UserEatExcel> ues = new ArrayList<>();
        if (users != null) {
            for (TNewUser u : users) {
                UserEatExcel e = new UserEatExcel();
                e.setName(u.getName());
                e.setSex(u.getSex());
                e.setJob(u.getJob());
                e.setLinkPhone(u.getLinkPhone());
                e.setPickUp(u.getPickUp());
                e.setTranslate(u.getTranslate());
                e.setFollow(u.getFollow());
                e.setAccompany(u.getAccompany());
                e.setEmail(u.getEmail());
                e.setCreateTime(u.getCreateTime());
                e.setUpdateTime(u.getUpdateTime());
                e.setCard(u.getCard());
                e.setCompany(u.getCompany());
                e.setPhone(u.getPhone());

                e.setEatAddRemark(u.getEatAddRemark());
                e.setEatArrange(u.getEatArrange());
                e.setEatArrangeRemark(u.getEatArrangeRemark());
                e.setEatAttention(u.getEatAttention());
                e.setEatDinner(u.getEatDinner());
                e.setEatEnd(u.getEatEnd());
                e.setEatEndRemark(u.getEatEndRemark());
                e.setEatEndRemarkName(u.getEatEndRemarkName());
                e.setEatLunch(u.getEatLunch());
                e.setEatPayType(u.getEatPayType());
                e.setEatStatus(u.getEatStatus());
                e.setEatStatusReamrkName(u.getEatStatusReamrkName());
                e.setEatStatusRemark(u.getEatStatusRemark());
                e.setEatWorkMeal(u.getEatWorkMeal());
                ues.add(e);
            }
        }
        ExcelUtils.writeExcel(response, ues, UserEatExcel.class, "客户个人用餐表");
    }
}
