package com.stylefeng.guns.modular.system.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.enums.ArrangeType;
import com.stylefeng.guns.core.enums.EndType;
import com.stylefeng.guns.core.enums.ReceiveAndSendType;
import com.stylefeng.guns.core.enums.VerifyType;
import com.stylefeng.guns.core.log.LogObjectHolder;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.core.util.DateUtil;
import com.stylefeng.guns.modular.system.excel.UserCarExcel;
import com.stylefeng.guns.modular.system.model.TNewUser;
import com.stylefeng.guns.modular.system.model.TUserCar;
import com.stylefeng.guns.modular.system.model.User;
import com.stylefeng.guns.modular.system.service.ITNewUserService;
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
 * @Date 2019-09-19 19:03:26
 */
@Controller
@RequestMapping("/tUserCar")
public class TUserCarController extends BaseController {

    private String PREFIX = "/system/tUserCar/";

    @Autowired
    private IUserService iUserService;
    
    @Autowired
    private ITNewUserService newUserService;

    /**
     * 跳转到首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "tUserCar.html";
    }

    /**
     * 跳转到添加
     */
    @RequestMapping("/tUserCar_add")
    public String tUserCarAdd() {
        return PREFIX + "tUserCar_add.html";
    }

    /**
     * 跳转到修改
     */
    @RequestMapping("/tUserCar_update/{tUserCarId}")
    public String tUserCarUpdate(@PathVariable Integer tUserCarId, Model model) {
    	TNewUser newUser = newUserService.queryUserCarById(tUserCarId);
        model.addAttribute("item", newUser);
        LogObjectHolder.me().set(newUser);
        return PREFIX + "tUserCar_edit.html";
    }

    /**
     * 跳转到详情
     */
    @RequestMapping("/tUserCar_detail/{tUserCarId}")
    public String tUserCarDetail(@PathVariable Integer tUserCarId, Model model) {
        TNewUser user = newUserService.queryUserInfoById(tUserCarId);
        // 审核状态
        user.setCarStatusName(VerifyType.getTypeByIndex(user.getCarStatus()));
        // 结束状态
        user.setCarEndName(EndType.getTypeByIndex(user.getCarEnd()));
        model.addAttribute("item", user);
        LogObjectHolder.me().set(user);
        return PREFIX + "tUserCar_detail.html";
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
        /** 获取的TNewUser列表 */
        List<TNewUser> cars;
        if(!ShiroKit.getUser().getRoleList().contains(6)) {
        	cars = newUserService.queryUserCarByFiled(filed1, value1, filed2, value2, status, end, null);
        }else {
        	cars = newUserService.queryUserCarByFiled(filed1, value1, filed2, value2, status, end, ShiroKit.getUser().getId());
        }
        for (TNewUser tNewUser : cars) {
        	//结束状态
			tNewUser.setCarEndName(EndType.getTypeByIndex(tNewUser.getCarEnd()));
			//审核状态
			tNewUser.setCarStatusName(VerifyType.getTypeByIndex(tNewUser.getCarStatus()));
			//接车安排
			tNewUser.setjCarArrangeName(ArrangeType.getTypeByIndex(tNewUser.getjCarArrange()));
			//送车安排
			tNewUser.setsCarArrangeName(ArrangeType.getTypeByIndex(tNewUser.getsCarArrange()));
			//市区用车安排
			tNewUser.setcCarArrangeName(ArrangeType.getTypeByIndex(tNewUser.getcCarArrange()));
			//接车状态
			tNewUser.setjCarSTypeName(ReceiveAndSendType.getTypeByIndex(tNewUser.getjCarSType()));
			//市区用车状态
			tNewUser.setcCarSTypeName(ReceiveAndSendType.getTypeByIndex(tNewUser.getcCarSType()));
			//送车状态
			tNewUser.setsCarSTypeName(ReceiveAndSendType.getTypeByIndex(tNewUser.getsCarSType()));
        }
        return cars;
    }

    /**
     * 新增
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(TUserCar tUserCar) {
        /*tUserCar.setCreateTime(DateUtil.getTime());
        tUserCar.setStatus(0);
        tUserCar.setEnd(0);
        tUserCarService.insert(tUserCar);*/
        return SUCCESS_TIP;
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer tUserCarId) {
    	newUserService.deleteById(tUserCarId);
        return SUCCESS_TIP;
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(TNewUser tUserCar) {
    	tUserCar.setUpdateTime(DateUtil.getTime());
        newUserService.updateById(tUserCar);
        return SUCCESS_TIP;
    }

    /**
     * 详情
     */
    @RequestMapping(value = "/detail/{tUserCarId}")
    @ResponseBody
    public Object detail(@PathVariable("tUserCarId") Integer tUserCarId) {
        return newUserService.queryUserCarById(tUserCarId);
    }

    /**
     * 审核页面
     *
     * @param tUserCarId
     * @return
     */
    @RequestMapping(value = "/examine/{tUserCarId}")
    public String examine_html(@PathVariable("tUserCarId") Integer tUserCarId, Model model) {
        model.addAttribute("id", tUserCarId);
        model.addAttribute("item",newUserService.queryUserCarById(tUserCarId));
        return PREFIX + "tUserCar_examine.html";
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
    	TNewUser newUser = newUserService.queryUserCarById(id);
    	newUser.setCarStatus(status);
    	newUser.setCarStatusReamrkName(sRemarkName);
    	newUser.setCarStatusRemark(sRemarkContent);
    	newUserService.updateById(newUser);
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
        model.addAttribute("item", newUserService.queryUserCarById(tTeamCarId));
        return PREFIX + "tUserCar_make.html";
    }

    /**
     * 安排
     *
     * @return
     */
    @RequestMapping(value = "/make_do")
    @ResponseBody
    public Object make_do(TNewUser user) {
    	this.newUserService.updateById(user);
        return SUCCESS_TIP;
    }

    /**
     * 结束页面
     *
     * @param tUserCarId
     * @param model
     * @return
     */
    @RequestMapping("/end/{tUserCarId}")
    public String end_html(@PathVariable("tUserCarId") Integer tUserCarId, Model model) {
        model.addAttribute("id", tUserCarId);
        model.addAttribute("item",newUserService.queryUserCarById(tUserCarId));
        return PREFIX + "tUserCar_end.html";
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
    	TNewUser user = newUserService.queryUserCarById(id);
    	user.setCarEnd(end);
    	user.setCarEndRemarkName(eRemarkName);
    	user.setCarEndRemark(eRemarkContent);
    	user.setjCarSType(jCarSType);
    	user.setsCarSType(sCarSType);
    	user.setcCarSType(cCarSType);
        this.newUserService.updateById(user);
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
        List<UserCarExcel> ucs = new ArrayList<>();
        if (users != null) {
            for (TNewUser u : users) {
                UserCarExcel c = new UserCarExcel();
                c.setName(u.getName());
                c.setSex(u.getSex());
                c.setJob(u.getJob());
                c.setLinkPhone(u.getLinkPhone());
                c.setPickUp(u.getPickUp());
                c.setTranslate(u.getTranslate());
                c.setFollow(u.getFollow());
                c.setAccompany(u.getAccompany());
                c.setEmail(u.getEmail());
                c.setCreateTime(u.getCreateTime());
                c.setUpdateTime(u.getUpdateTime());
                c.setCard(u.getCard());
                c.setCompany(u.getCompany());
                c.setPhone(u.getPhone());

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
        ExcelUtils.writeExcel(response, ucs, UserCarExcel.class, "客户个人用车表");
    }
}
