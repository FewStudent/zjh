package com.stylefeng.guns.modular.system.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.enums.ArrangeType;
import com.stylefeng.guns.core.enums.EndType;
import com.stylefeng.guns.core.enums.PayType;
import com.stylefeng.guns.core.enums.VerifyType;
import com.stylefeng.guns.core.enums.YesOrNo;
import com.stylefeng.guns.core.log.LogObjectHolder;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.core.util.DateUtil;
import com.stylefeng.guns.modular.system.excel.TeamEatExcel;
import com.stylefeng.guns.modular.system.model.TNewTeam;
import com.stylefeng.guns.modular.system.model.TTeamEat;
import com.stylefeng.guns.modular.system.model.User;
import com.stylefeng.guns.modular.system.service.ITNewTeamService;
import com.stylefeng.guns.modular.system.service.ITTeamEatService;
import com.stylefeng.guns.modular.system.service.IUserService;
import com.stylefeng.guns.modular.system.util.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 控制器
 *
 * @author fengshuonan
 * @Date 2019-09-19 19:02:59
 */
@Controller
@RequestMapping("/tTeamEat")
public class TTeamEatController extends BaseController {

    private String PREFIX = "/system/tTeamEat/";

    @Autowired
    private ITTeamEatService tTeamEatService;
    @Autowired
    private IUserService userService;
    @Autowired
    private ITNewTeamService newTeamService;

    /**
     * 跳转到首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "tTeamEat.html";
    }

    /**
     * 跳转到添加
     */
    @RequestMapping("/tTeamEat_add")
    public String tTeamEatAdd() {
        return PREFIX + "tTeamEat_add.html";
    }

    /**
     * 跳转到修改
     */
    @RequestMapping("/tTeamEat_update/{tTeamEatId}")
    public String tTeamEatUpdate(@PathVariable Integer tTeamEatId, Model model) {
        TNewTeam tUserEat = newTeamService.selectById(tTeamEatId);
        model.addAttribute("item", tUserEat);
        LogObjectHolder.me().set(tUserEat);
        return PREFIX + "tTeamEat_edit.html";
    }

    /**
     * 跳转到详情
     */
    @RequestMapping("/tTeamEat_detail/{tTeamEatId}")
    public String tTeamEatDetail(@PathVariable Integer tTeamEatId, Model model) {
        TNewTeam eat = newTeamService.queryTeamEatById(tTeamEatId);
        model.addAttribute("item", eat);
        LogObjectHolder.me().set(eat);
        return PREFIX + "tTeamEat_detail.html";
    }

    /**
     * 获取列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(Integer status, Integer end, String filed1,String filed2,String value1,String value2) {
        if (status != null && status.intValue() == -1) {
            status = null;
        }
        if (end != null && end.intValue() == -1) {
            end = null;
        }
        // 判断是否是录入员，如果是录入员 只能看到自己录入的信息
        List<TNewTeam> userEats;
        if (!ShiroKit.getUser().getRoleList().contains(6)) {
            userEats = newTeamService.queryTeamEatByFiled(filed1, value1, filed2, value2, status, end, null);
        } else {
            userEats = newTeamService.queryTeamEatByFiled(filed1, value1, filed2, value2, status, end, ShiroKit.getUser().getId());
        }
        for (TNewTeam eat : userEats) {
            // 付费方式
            eat.setEatPayTypeName(PayType.getTypeByIndex(eat.getEatPayType()));
            // 审核状态
            eat.setEatStatusName(VerifyType.getTypeByIndex(eat.getEatStatus()));
            // 结束状态
            System.out.println("end:" + eat.getEatEnd());
            eat.setEatEndName(EndType.getTypeByIndex(eat.getEatEnd()));
            //是否晚餐
            eat.setEatDinnerName(YesOrNo.getTypeByIndex(eat.getEatDinner()));
            //安排情况
            eat.setEatArrangeName(ArrangeType.getTypeByIndex(eat.getEatArrange()));
        }
        return userEats;
    }

    /**
     * 新增
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(TTeamEat tTeamEat) {
        tTeamEat.setCreateTime(DateUtil.getTime());
        tTeamEat.setStatus(0);
        tTeamEat.setEnd(0);
        tTeamEatService.insert(tTeamEat);
        return SUCCESS_TIP;
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer tTeamEatId) {
        newTeamService.deleteById(tTeamEatId);
        return SUCCESS_TIP;
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(TNewTeam tTeamEat) {
        tTeamEat.setUpdateTime(DateUtil.getTime());
        newTeamService.updateById(tTeamEat);
        return SUCCESS_TIP;
    }

    /**
     * 详情
     */
    @RequestMapping(value = "/detail/{tTeamEatId}")
    @ResponseBody
    public Object detail(@PathVariable("tTeamEatId") Integer tTeamEatId) {
        return newTeamService.queryTeamEatById(tTeamEatId);
    }

    /**
     * 审核页面
     *
     * @param tTeamEatId
     * @return
     */
    @RequestMapping(value = "/examine/{tTeamEatId}")
    public String examine_html(@PathVariable("tTeamEatId") Integer tTeamEatId, Model model) {
        TNewTeam newUser = newTeamService.queryTeamEatById(tTeamEatId);
        model.addAttribute("id", tTeamEatId);
        model.addAttribute("item", newUser);
        return PREFIX + "tTeamEat_examine.html";
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
        TNewTeam newUser = this.newTeamService.queryTeamEatById(id);
        newUser.setEatStatus(status);
        newUser.setEatStatusRemark(sRemarkContent);
        newUser.setEatStatusReamrkName(sRemarkName);
        this.newTeamService.updateById(newUser);
        return SUCCESS_TIP;
    }

    /**
     * 安排页面
     *
     * @param tTeamEatId
     * @return
     */
    @RequestMapping(value = "/make/{tTeamEatId}")
    public String make(@PathVariable("tTeamEatId") Integer tTeamEatId, Model model) {
        TNewTeam newUser = newTeamService.queryTeamEatById(tTeamEatId);
        model.addAttribute("id", tTeamEatId);
        model.addAttribute("item", newUser);
        return PREFIX + "tTeamEat_make.html";
    }

    /**
     * 安排
     *
     * @param id
     * @param restaurant
     * @param restaurantDate
     * @param restaurantPeoples
     * @param restaurantAttention
     * @return
     */
    @RequestMapping(value = "/make_do")
    @ResponseBody
    public Object make_do(Integer id,Integer arrange, String restaurant, String restaurantDate, Integer restaurantPeoples, String restaurantAttention) {
        System.out.println(id);
        TNewTeam newUser = this.newTeamService.queryTeamEatById(id);
        newUser.setEatArrange(arrange);
        newUser.setEatArrangeRemark(restaurantAttention);
        this.newTeamService.updateById(newUser);
        return SUCCESS_TIP;
    }

    /**
     * 结束页面
     *
     * @param tTeamEatId
     * @param model
     * @return
     */
    @RequestMapping("/end/{tTeamEatId}")
    public String end_html(@PathVariable("tTeamEatId") Integer tTeamEatId, Model model) {
        TNewTeam newUser = newTeamService.queryTeamEatById(tTeamEatId);
        model.addAttribute("id", tTeamEatId);
        model.addAttribute("item", newUser);
        return PREFIX + "tTeamEat_end.html";
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
        TNewTeam newUser = this.newTeamService.queryTeamEatById(id);
        newUser.setEatEnd(end);
        newUser.setEatEndRemark(eRemarkName);
        newUser.setEatEndRemarkName(eRemarkContent);
        newTeamService.updateById(newUser);
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
        User user = this.userService.selectById(adminId);
        String roleid = user.getRoleid();
        List<TNewTeam> newTeams = new ArrayList<>();
        if (roleid.contains("6")) {
            Map<String, Object> params = new HashMap<>();
            params.put("create_by", adminId);
            newTeams = this.newTeamService.selectByMap(params);
        } else {
            newTeams = this.newTeamService.selectList(null);
        }
        List<TeamEatExcel> tes = new ArrayList<>();
        if (newTeams != null) {
            for (TNewTeam u : newTeams) {
                TeamEatExcel e = new TeamEatExcel();
                e.setCompany(u.getCompany());
                e.setArea(u.getArea());
                e.setCard(u.getCard());
                e.setCompanyLeader(u.getCompanyLeader());
                e.setCreateTime(u.getCreateTime());
                e.setUpdateTime(u.getUpdateTime());
                e.setPickUp(u.getPickUp());
                e.setTeamNums(u.getTeamNums());
                e.setLinkUser(u.getLinkUser());
                e.setLinkPhone(u.getLinkPhone());

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
                tes.add(e);
            }
        }
        ExcelUtils.writeExcel(response, tes, TeamEatExcel.class, "客户团体用餐表");
    }
}
