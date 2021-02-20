package com.stylefeng.guns.modular.system.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.enums.ArrangeType;
import com.stylefeng.guns.core.enums.EndType;
import com.stylefeng.guns.core.enums.ReceiveAndSendType;
import com.stylefeng.guns.core.enums.VerifyType;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.core.util.DateUtil;
import com.stylefeng.guns.modular.system.excel.TeamCarExcel;
import com.stylefeng.guns.modular.system.model.*;
import com.stylefeng.guns.modular.system.service.ITNewTeamService;
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
import com.stylefeng.guns.modular.system.service.ITTeamCarService;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 控制器
 *
 * @author fengshuonan
 * @Date 2019-09-19 19:02:53
 */
@Controller
@RequestMapping("/tTeamCar")
public class TTeamCarController extends BaseController {

    private String PREFIX = "/system/tTeamCar/";

    @Autowired
    private IUserService userService;
    @Autowired
    private ITNewTeamService newTeamService;

    /**
     * 跳转到首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "tTeamCar.html";
    }

    /**
     * 跳转到添加
     */
    @RequestMapping("/tTeamCar_add")
    public String tTeamCarAdd() {
        return PREFIX + "tTeamCar_add.html";
    }

    /**
     * 跳转到修改
     */
    @RequestMapping("/tTeamCar_update/{tTeamCarId}")
    public String tTeamCarUpdate(@PathVariable Integer tTeamCarId, Model model) {
        TNewTeam newUser = newTeamService.queryTeamCarById(tTeamCarId);
        model.addAttribute("item", newUser);
        LogObjectHolder.me().set(newUser);
        return PREFIX + "tTeamCar_edit.html";
    }

    /**
     * 跳转到详情
     */
    @RequestMapping("/tTeamCar_detail/{tTeamCarId}")
    public String tTeamCarDetail(@PathVariable Integer tTeamCarId, Model model) {
        TNewTeam user = newTeamService.queryTeamInfoById(tTeamCarId);
        // 审核状态
        user.setCarStatusName(VerifyType.getTypeByIndex(user.getCarStatus()));
        // 结束状态
        user.setCarEndName(EndType.getTypeByIndex(user.getCarEnd()));
        model.addAttribute("item", user);
        LogObjectHolder.me().set(user);
        return PREFIX + "tTeamCar_detail.html";
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
        /** 获取的TNewTeam列表 */
        List<TNewTeam> cars;
        if(ShiroKit.getUser().getRoleList().contains(1) || ShiroKit.getUser().getRoleList().contains(10)) {
            cars = newTeamService.queryTeamCarByFiled(filed1, value1, filed2, value2, status, end, null);
        }else {
            cars = newTeamService.queryTeamCarByFiled(filed1, value1, filed2, value2, status, end, ShiroKit.getUser().getId());
        }
        for (TNewTeam TNewTeam : cars) {
            //结束状态
            TNewTeam.setCarEndName(EndType.getTypeByIndex(TNewTeam.getCarEnd()));
            //审核状态
            TNewTeam.setCarStatusName(VerifyType.getTypeByIndex(TNewTeam.getCarStatus()));
            //接车安排
            TNewTeam.setjCarArrangeName(ArrangeType.getTypeByIndex(TNewTeam.getjCarArrange()));
            //送车安排
            TNewTeam.setsCarArrangeName(ArrangeType.getTypeByIndex(TNewTeam.getsCarArrange()));
            //市区用车安排
            TNewTeam.setcCarArrangeName(ArrangeType.getTypeByIndex(TNewTeam.getcCarArrange()));
            //接车状态
            TNewTeam.setjCarSTypeName(ReceiveAndSendType.getTypeByIndex(TNewTeam.getjCarSType()));
            //市区用车状态
            TNewTeam.setcCarSTypeName(ReceiveAndSendType.getTypeByIndex(TNewTeam.getcCarSType()));
            //送车状态
            TNewTeam.setsCarSTypeName(ReceiveAndSendType.getTypeByIndex(TNewTeam.getsCarSType()));
        }
        return cars;
    }

    /**
     * 新增
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(TTeamCar tTeamCar) {
        //TODO
        return SUCCESS_TIP;
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer tTeamCarId) {
        newTeamService.deleteById(tTeamCarId);
        return SUCCESS_TIP;
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(TNewTeam tUserCar) {
        tUserCar.setUpdateTime(DateUtil.getTime());
        newTeamService.updateById(tUserCar);
        return SUCCESS_TIP;
    }

    /**
     * 详情
     */
    @RequestMapping(value = "/detail/{tTeamCarId}")
    @ResponseBody
    public Object detail(@PathVariable("tTeamCarId") Integer tTeamCarId) {
        return newTeamService.queryTeamCarById(tTeamCarId);
    }

    /**
     * 审核页面
     *
     * @param tTeamCarId
     * @return
     */
    @RequestMapping(value = "/examine/{tTeamCarId}")
    public String examine_html(@PathVariable("tTeamCarId") Integer tTeamCarId, Model model) {
        model.addAttribute("id", tTeamCarId);
        model.addAttribute("item",newTeamService.queryTeamCarById(tTeamCarId));
        return PREFIX + "tTeamCar_examine.html";
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
        TNewTeam newUser = newTeamService.queryTeamCarById(id);
        newUser.setCarStatus(status);
        newUser.setCarStatusReamrkName(sRemarkName);
        newUser.setCarStatusRemark(sRemarkContent);
        newTeamService.updateById(newUser);
        return SUCCESS_TIP;
    }

    /**
     * 结束页面
     *
     * @param tTeamCarId
     * @param model
     * @return
     */
    @RequestMapping("/end/{tTeamCarId}")
    public String end_html(@PathVariable("tTeamCarId") Integer tTeamCarId, Model model) {
        model.addAttribute("id", tTeamCarId);
        model.addAttribute("item",newTeamService.queryTeamCarById(tTeamCarId));
        return PREFIX + "tTeamCar_end.html";
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
    public Object end(Integer id, Integer end, String eRemarkName, String eRemarkContent,Integer jCarSType,Integer sCarSType,Integer cCarSType) {
        TNewTeam user = newTeamService.queryTeamCarById(id);
        user.setCarEnd(end);
        user.setCarEndRemarkName(eRemarkName);
        user.setCarEndRemark(eRemarkContent);
        user.setjCarSType(jCarSType);
        user.setsCarSType(sCarSType);
        user.setcCarSType(cCarSType);
        this.newTeamService.updateById(user);
        return SUCCESS_TIP;
    }

    /**
     * 安排页面
     *
     * @param tTeamCarId
     * @return
     */
    @RequestMapping(value = "/make/{tTeamCarId}")
    public String make(@PathVariable("tTeamCarId") Integer tTeamCarId, Model model) {
        model.addAttribute("item", newTeamService.queryTeamCarById(tTeamCarId));
        return PREFIX + "tTeamCar_make.html";
    }

    /**
     * 安排
     *
     * @return
     */
    @RequestMapping(value = "/make_do")
    @ResponseBody
    public Object make_do(TNewTeam team) {
        this.newTeamService.updateById(team);
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
        List<TNewTeam> teams = new ArrayList<>();
        String roleid = user.getRoleid();
        if (roleid.contains("6")) {
            Map<String, Object> params = new HashMap<>();
            params.put("create_by", adminId);
            teams = this.newTeamService.selectByMap(params);
        } else {
            teams = this.newTeamService.selectList(null);
        }
        List<TeamCarExcel> ucs = new ArrayList<>();
        if (teams != null) {
            for (TNewTeam u : teams) {
                TeamCarExcel c = new TeamCarExcel();
                c.setCompany(u.getCompany());
                c.setArea(u.getArea());
                c.setCard(u.getCard());
                c.setCompanyLeader(u.getCompanyLeader());
                c.setCreateTime(u.getCreateTime());
                c.setUpdateTime(u.getUpdateTime());
                c.setPickUp(u.getPickUp());
                c.setTeamNums(u.getTeamNums());
                c.setLinkUser(u.getLinkUser());
                c.setLinkPhone(u.getLinkPhone());

                c.setjAccompanyLeader(u.getjAccompanyLeader());
                c.setjAddRemark(u.getjAddRemark());
                c.setjArrangeRemark(u.getjArrangeRemark());
                c.setjCarArrange(u.getjCarArrange());
                c.setjCarCard(u.getjCarCard());
                c.setjCarSType(u.getjCarSType());
                c.setjCarType(u.getjCarType());
                c.setjDestination(u.getjDestination());
                c.setjDriver(u.getjDriver());
                c.setjDriverPhone(u.getjDriverPhone());
                c.setjHasStopCard(u.getjHasStopCard());
                c.setjPayType(u.getjPayType());
                c.setjRidePeoples(u.getjRidePeoples());
                c.setjRidePlace(u.getjRidePlace());
                c.setjTrafficNum(u.getjTrafficNum());
                c.setjUseCarDate(u.getjUseCarDate());
                c.setjUseCarTime(u.getjUseCarTime());

                c.setsAccompanyLeader(u.getsAccompanyLeader());
                c.setsAddRemark(u.getsAddRemark());
                c.setsArrangeRemark(u.getsArrangeRemark());
                c.setsCarArrange(u.getsCarArrange());
                c.setsCarCard(u.getsCarCard());
                c.setsCarSType(u.getsCarSType());
                c.setsCarType(u.getsCarType());
                c.setsDestination(u.getsDestination());
                c.setsDriver(u.getsDriver());
                c.setsDriverPhone(u.getsDriverPhone());
                c.setsHasStopCard(u.getsHasStopCard());
                c.setsPayType(u.getsPayType());
                c.setsRidePeoples(u.getsRidePeoples());
                c.setsRidePlace(u.getsRidePlace());
                c.setsTrafficNum(u.getsTrafficNum());
                c.setsUseCarDate(u.getsUseCarDate());
                c.setsUseCarTime(u.getsUseCarTime());

                c.setcAccompanyLeader(u.getcAccompanyLeader());
                c.setcAddRemark(u.getcAddRemark());
                c.setcArrangeRemark(u.getcArrangeRemark());
                c.setcCarArrange(u.getcCarArrange());
                c.setcCarCard(u.getcCarCard());
                c.setcCarSType(u.getcCarSType());
                c.setcCarType(u.getcCarType());
                c.setcDestination(u.getcDestination());
                c.setcDriver(u.getcDriver());
                c.setcDriverPhone(u.getcDriverPhone());
                c.setcHasStopCard(u.getcHasStopCard());
                c.setcPayType(u.getcPayType());
                c.setcRidePeoples(u.getcRidePeoples());
                c.setcRidePlace(u.getcRidePlace());
                c.setcUseCarDate(u.getcUseCarDate());
                c.setcUseCarTime(u.getcUseCarTime());

                c.setCarStatus(u.getCarStatus());
                c.setCarStatusReamrkName(u.getCarStatusReamrkName());
                c.setCarStatusRemark(u.getCarStatusRemark());
                c.setCarEnd(u.getCarEnd());
                c.setCarEndRemark(u.getCarEndName());
                c.setCarEndRemarkName(u.getCarEndRemarkName());

                ucs.add(c);
            }
        }
        ExcelUtils.writeExcel(response, ucs, TeamCarExcel.class, "客户团队用车表");
    }
}
