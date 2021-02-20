package com.stylefeng.guns.modular.system.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.enums.ArrangeType;
import com.stylefeng.guns.core.enums.EndType;
import com.stylefeng.guns.core.enums.PayType;
import com.stylefeng.guns.core.enums.VerifyType;
import com.stylefeng.guns.core.log.LogObjectHolder;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.core.util.DateUtil;
import com.stylefeng.guns.modular.system.excel.UserHouseExcel;
import com.stylefeng.guns.modular.system.model.TNewUser;
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
 * @Date 2019-09-19 19:03:42
 */
@Controller
@RequestMapping("/tUserHouse")
public class TUserHouseController extends BaseController {

    private String PREFIX = "/system/tUserHouse/";

    @Autowired
    private IUserService iUserService;
    @Autowired
    private ITNewUserService newUserService;

    /**
     * 跳转到首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "tUserHouse.html";
    }

    /**
     * 跳转到添加
     */
    @RequestMapping("/tUserHouse_add")
    public String tUserHouseAdd() {
        return PREFIX + "tUserHouse_add.html";
    }

    /**
     * 跳转到修改
     */
    @RequestMapping("/tUserHouse_update/{tUserHouseId}")
    public String tUserHouseUpdate(@PathVariable Integer tUserHouseId, Model model) {
        TNewUser newUser = newUserService.queryUserInfoById(tUserHouseId);
        model.addAttribute("item", newUser);
        LogObjectHolder.me().set(newUser);
        return PREFIX + "tUserHouse_edit.html";
    }

    /**
     * 跳转到详情
     */
    @RequestMapping("/tUserHouse_detail/{tUserHouseId}")
    public String tUserHouseDetail(@PathVariable Integer tUserHouseId, Model model) {
        TNewUser newUser = newUserService.queryUserHouseById(tUserHouseId);
        model.addAttribute("item", newUser);
        LogObjectHolder.me().set(newUser);
        return PREFIX + "tUserHouse_detail.html";
    }


    /**
     * 获取列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String filed1, String filed2, String value1, String value2, Integer status, Integer end) {
        if (status != null && status.intValue() == -1) {
            status = null;
        }
        if (end != null && end.intValue() == -1) {
            end = null;
        }
        List<TNewUser> users;
        if (!ShiroKit.getUser().getRoleList().contains(6)) {
            users = newUserService.queryUserHouseByFiled(filed1, value1, filed2, value2, status, end, null);
        } else {
            users = newUserService.queryUserHouseByFiled(filed1, value1, filed2, value2, status, end, ShiroKit.getUser().getId());
        }
        for (TNewUser house : users) {
            // 性别
            Integer sex = house.getSex();
            if (sex != null) {
                if (sex.intValue() == 0) {
                    house.setSexName("男");
                } else if (sex.intValue() == 1) {
                    house.setSexName("女");
                } else {
                    house.setSexName("--");
                }
            }
            house.setHousePayTypeName(PayType.getTypeByIndex(house.getHousePayType()));
            house.setHouseEndName(EndType.getTypeByIndex(house.getHouseEnd()));
            house.setHouseStatusName(VerifyType.getTypeByIndex(house.getHouseStatus()));
            house.setHouseArrangeName(ArrangeType.getTypeByIndex(house.getHouseArrange()));
        }
        return users;
    }

    /**
     * 新增
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(TNewUser tUserHouse) {
        tUserHouse.setCreateTime(DateUtil.getTime());
        tUserHouse.setHouseStatus(0);
        tUserHouse.setHouseEnd(0);
        newUserService.insert(tUserHouse);
        return SUCCESS_TIP;
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer tUserHouseId) {
        newUserService.deleteById(tUserHouseId);
        return SUCCESS_TIP;
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(TNewUser tUserHouse) {
        tUserHouse.setUpdateTime(DateUtil.getTime());
        newUserService.updateById(tUserHouse);
        return SUCCESS_TIP;
    }

    /**
     * 详情
     */
    @RequestMapping(value = "/detail/{tUserHouseId}")
    @ResponseBody
    public Object detail(@PathVariable("tUserHouseId") Integer tUserHouseId) {
        return newUserService.queryUserHouseById(tUserHouseId);
    }

    /**
     * 审核页面
     *
     * @param tUserHouseId
     * @return
     */
    @RequestMapping(value = "/examine/{tUserHouseId}")
    public String examine_html(@PathVariable("tUserHouseId") Integer tUserHouseId, Model model) {
        model.addAttribute("id", tUserHouseId);
        model.addAttribute("item", newUserService.queryUserHouseById(tUserHouseId));
        return PREFIX + "tUserHouse_examine.html";
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
        TNewUser newUser = this.newUserService.queryUserHouseById(id);
        newUser.setHouseStatus(status);
        newUser.setHouseStatusReamrkName(sRemarkName);
        newUser.setHouseStatusRemark(sRemarkContent);
        this.newUserService.updateById(newUser);
        return SUCCESS_TIP;
    }

    /**
     * 安排页面
     *
     * @param tUserHouseId
     * @return
     */
    @RequestMapping(value = "/make/{tUserHouseId}")
    public String make(@PathVariable("tUserHouseId") Integer tUserHouseId, Model model) {
        model.addAttribute("id", tUserHouseId);
        model.addAttribute("item", newUserService.queryUserHouseById(tUserHouseId));
        return PREFIX + "tUserHouse_make.html";
    }

    /**
     * 安排
     *
     * @param id
     */
    @RequestMapping(value = "/make_do")
    @ResponseBody
    public Object make_do(Integer id, String remark,Integer arrange) {
        TNewUser newUser = newUserService.queryUserHouseById(id);
        newUser.setHouseArrange(arrange);
        newUser.setHouseArrangeRemark(remark);
        newUserService.updateById(newUser);
        return SUCCESS_TIP;
    }


    /**
     * 结束页面
     *
     * @param tUserHouseId
     * @param model
     * @return
     */
    @RequestMapping("/end/{tUserHouseId}")
    public String end_html(@PathVariable("tUserHouseId") Integer tUserHouseId, Model model) {
        model.addAttribute("id", tUserHouseId);
        model.addAttribute("item", newUserService.queryUserHouseById(tUserHouseId));
        return PREFIX + "tUserHouse_end.html";
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
        TNewUser newUser = this.newUserService.selectById(id);
        newUser.setHouseEnd(end);
        newUser.setHouseEndRemark(eRemarkContent);
        newUser.setHouseEndRemarkName(eRemarkName);
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
        List<UserHouseExcel> uhs = new ArrayList<>();
        if (users != null) {
            for (TNewUser u : users) {
                UserHouseExcel h = new UserHouseExcel();
                h.setName(u.getName());
                h.setSex(u.getSex());
                h.setJob(u.getJob());
                h.setLinkPhone(u.getLinkPhone());
                h.setPickUp(u.getPickUp());
                h.setTranslate(u.getTranslate());
                h.setFollow(u.getFollow());
                h.setAccompany(u.getAccompany());
                h.setEmail(u.getEmail());
                h.setCreateTime(u.getCreateTime());
                h.setUpdateTime(u.getUpdateTime());
                h.setCard(u.getCard());
                h.setCompany(u.getCompany());
                h.setPhone(u.getPhone());

                h.setHotelName(u.getHotelName());
                h.setHotelRoomNum(u.getHotelRoomNum());
                h.setHotelRoomType(u.getHotelRoomType());
                h.setHotelVacant(u.getHotelVacant());
                h.setHouseAddRemark(u.getHouseAddRemark());
                h.setHouseArrange(u.getHouseArrange());
                h.setHouseArrangeRemark(u.getHouseArrangeRemark());
                h.setHouseEnd(u.getHouseEnd());
                h.setHouseEndRemark(u.getHouseEndRemark());
                h.setHouseEndRemarkName(u.getHouseEndRemarkName());
                h.setHouseInDate(u.getHouseInDate());
                h.setHouseOutDate(u.getHouseOutDate());
                h.setHousePayType(u.getHousePayType());
                h.setHouseStatus(u.getHouseStatus());
                h.setHouseStatusReamrkName(u.getHouseStatusReamrkName());
                h.setHouseStatusRemark(u.getHouseStatusRemark());
                h.setPrice(u.getPrice());
                h.setRoomTotal(u.getRoomTotal());
                h.setSplicePeople(u.getSplicePeople());
                h.setSpliceRoom(u.getSpliceRoom());
                h.setTotalPrice(u.getTotalPrice());
                uhs.add(h);
            }
        }
        ExcelUtils.writeExcel(response, uhs, UserHouseExcel.class, "客户个人住房表");
    }
}
