package com.stylefeng.guns.modular.system.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.core.util.DateUtil;
import com.stylefeng.guns.modular.system.excel.UserExcel;
import com.stylefeng.guns.modular.system.model.*;
import com.stylefeng.guns.modular.system.service.*;
import com.stylefeng.guns.modular.system.util.ExcelUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

import java.util.*;

/**
 * 控制器
 *
 * @author fengshuonan
 * @Date 2019-09-19 19:03:10
 */
@Controller
@RequestMapping("/tUser")
public class TUserController extends BaseController {

    private String PREFIX = "/system/tUser/";

    @Autowired
    private IUserService iUserService;
    @Autowired
    private ITNewUserService iNewUserService;
    @Autowired
    private ITFileService fileService;

    /**
     * 跳转到首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "tUser.html";
    }

    /**
     * 跳转到添加
     */
    @RequestMapping("/tUser_add")
    public String tUserAdd() {
        return PREFIX + "tUser_add.html";
    }

    /**
     * 跳转到修改
     */
    @RequestMapping("/tUser_update/{tUserId}")
    public String tUserUpdate(@PathVariable Integer tUserId, Model model) {
        System.out.println("updateid:" + tUserId);
        TNewUser tUser = iNewUserService.queryUserInfoById(tUserId);
        // 演讲材料文件
        String sfile = tUser.getSpeechFile();
        if (sfile != null && !sfile.equals("")) {
            String[] sfileArr = sfile.split(",");
            Set<Integer> ids = new HashSet<>();
            for (String str : sfileArr) {
                ids.add(Integer.valueOf(str));
            }
            List<TFile> sfiles = this.fileService.selectBatchIds(ids);
            model.addAttribute("sfiles", sfiles);
        } else {
            model.addAttribute("sfiles", null);
        }
        // 活动图片文件
        String photo = tUser.getPhotoFile();
        if (photo != null && !photo.equals("")) {
            String[] photoArr = photo.split(",");
            Set<Integer> ids = new HashSet<>();

            for (String str : photoArr) {
                ids.add(Integer.valueOf(str));
            }
            List<TFile> photos = this.fileService.selectBatchIds(ids);
            model.addAttribute("photos", photos);
        } else {
            model.addAttribute("photos", null);
        }
        model.addAttribute("item", tUser);
        LogObjectHolder.me().set(tUser);
        return PREFIX + "tUser_edit.html";
    }

    /**
     * 跳转到详情
     */
    @RequestMapping("/tUser_detail/{tUserId}")
    public String tUserDetail(@PathVariable Integer tUserId, Model model) {
        TNewUser tUser = iNewUserService.queryUserInfoById(tUserId);

        // 演讲材料文件
        String sfile = tUser.getSpeechFile();
        if (sfile != null && !sfile.equals("")) {
            String[] sfileArr = sfile.split(",");
            Set<Integer> ids = new HashSet<>();
            for (String str : sfileArr) {
                ids.add(Integer.valueOf(str));
            }
            List<TFile> sfiles = this.fileService.selectBatchIds(ids);
            model.addAttribute("sfiles", sfiles);
        } else {
            model.addAttribute("sfiles", null);
        }
        // 活动图片文件
        String photo = tUser.getPhotoFile();
        if (photo != null && !photo.equals("")) {
            String[] photoArr = photo.split(",");
            Set<Integer> ids = new HashSet<>();

            for (String str : photoArr) {
                ids.add(Integer.valueOf(str));
            }
            List<TFile> photos = this.fileService.selectBatchIds(ids);
            model.addAttribute("photos", photos);
        } else {
            model.addAttribute("photos", null);
        }
        model.addAttribute("item", tUser);
        LogObjectHolder.me().set(tUser);
        return PREFIX + "tUser_detail.html";
    }

    /**
     * 跳转到用餐添加
     *
     * @param tUserId
     * @param model
     * @return
     */
    @RequestMapping("/eat_add/{tUserId}")
    public String tUserEatAdd(@PathVariable Integer tUserId, Model model) {
        model.addAttribute("userId", tUserId);
        return PREFIX + "tUserEat_add.html";
    }

    /**
     * 跳转到用车添加
     *
     * @param tUserId
     * @param model
     * @return
     */
    @RequestMapping("/car_add/{tUserId}")
    public String tUserCarAdd(@PathVariable Integer tUserId, Model model) {
        model.addAttribute("userId", tUserId);
        return PREFIX + "tUserCar_add.html";
    }

    /**
     * 跳转到住房添加
     *
     * @param tUserId
     * @param model
     * @return
     */
    @RequestMapping("/house_add/{tUserId}")
    public String tUserHouseAdd(@PathVariable Integer tUserId, Model model) {
        model.addAttribute("userId", tUserId);
        return PREFIX + "tUserHouse_add.html";
    }

    /**
     * 跳转到档案添加
     *
     * @param tUserId
     * @param model
     * @return
     */
    @RequestMapping("/archive_add/{tUserId}")
    public String tUserArchiveAdd(@PathVariable Integer tUserId, Model model) {
        model.addAttribute("userId", tUserId);
        return PREFIX + "tUserArchives_add.html";
    }

    /**
     * 获取列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String filed1, String value1, String filed2, String value2) {
        // 判断是否是录入员，如果是录入员 只能看到自己录入的信息
        List<TNewUser> users;
        if (!ShiroKit.getUser().getRoleList().contains(6)) {
            users = iNewUserService.queryUserInfoByFiled(filed1, value1, filed2, value2, null);
        } else {
            users = iNewUserService.queryUserInfoByFiled(filed1, value1, filed2, value2, ShiroKit.getUser().getId());
        }
        for (TNewUser user : users) {
            //性别
            Integer sex = user.getSex();
            if (sex != null) {
                if (sex.intValue() == 0) {
                    user.setSexName("男");
                } else if (sex.intValue() == 1) {
                    user.setSexName("女");
                } else {
                    user.setSexName("--");
                }
            }
            // 证件类型
            Integer certificates = user.getCard();
            if (certificates != null) {
                if (certificates.intValue() == 0) {
                    user.setCertificatesName("贵宾证");
                } else if (certificates.intValue() == 1) {
                    user.setCertificatesName("嘉宾证");
                } else if (certificates.intValue() == 2) {
                    user.setCertificatesName("参观证");
                } else {
                    user.setCertificatesName("--");
                }
            }
        }
        return users;
    }

    /**
     * 新增
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(TNewUser tUser, String sfile, String imgfile) {
        tUser.setCreateTime(DateUtil.getTime());
        tUser.setCreateBy(ShiroKit.getUser().getId());
        tUser.setSpeechFile(sfile);
        tUser.setPhotoFile(imgfile);
        iNewUserService.insert(tUser);
        return SUCCESS_TIP;
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer tUserId) {
        iNewUserService.deleteById(tUserId);
        // 删除关联的用车 用餐 住房 档案等信息
        return SUCCESS_TIP;
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(TNewUser tUser, String sfile, String imgfile) {
        TNewUser ot = this.iNewUserService.selectById(tUser.getId());
        tUser.setUpdateTime(DateUtil.getTime());
        tUser.setTranslate(tUser.getTranslater());
        if (sfile != null && !sfile.equals("")) {
            String osfile = ot.getSpeechFile();
            if (osfile != null && !osfile.equals("")) {
                if (osfile.substring(osfile.length() - 1).equals(",")) {
                    tUser.setSpeechFile(osfile + sfile);
                } else {
                    tUser.setSpeechFile(osfile + "," + sfile);
                }
            } else {
                tUser.setSpeechFile(sfile);
            }

        }
        if (imgfile != null && !imgfile.equals("")) {
            String opfile = ot.getPhotoFile();
            if (opfile != null && !opfile.equals("")) {
                if (opfile.substring(opfile.length() - 1).equals(",")) {
                    tUser.setPhotoFile(opfile + imgfile);
                } else {
                    tUser.setPhotoFile(opfile + "," + imgfile);
                }
            } else {
                tUser.setPhotoFile(imgfile);
            }
        }
        iNewUserService.updateById(tUser);
        return SUCCESS_TIP;
    }

    /**
     * 详情
     */
    @RequestMapping(value = "/detail/{tUserId}")
    @ResponseBody
    public Object detail(@PathVariable("tUserId") Integer tUserId) {
        return iNewUserService.queryUserInfoById(tUserId);
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
            users = this.iNewUserService.selectByMap(params);
        } else {
            users = this.iNewUserService.selectList(null);
        }
        List<UserExcel> ues = new ArrayList<>();
        if (users != null) {
            for (TNewUser u : users) {
                UserExcel e = new UserExcel();
                // 基础信息
                e.setName(u.getName());
                e.setSex(u.getSex());
                e.setCompany(u.getCompany());
                e.setJob(u.getJob());
                e.setCard(u.getCard());
                e.setPickUp(u.getPickUp());
                e.setLinkPhone(u.getLinkPhone());
                e.setPhone(u.getPhone());
                e.setFollow(u.getFollow());
                e.setAccompany(u.getAccompany());
                e.setTranslate(u.getTranslate());
                e.setEmail(u.getEmail());
                // 活动信息
                e.setAccount(u.getAccount());
                e.setAccountBlank(u.getAccountBlank());
                e.setAccountName(u.getAccountName());
                e.setActivity(u.getActivity());
                e.setActivityAddRemark(u.getActivityAddRemark());
                e.setActivityAddRemarkName(u.getActivityAddRemarkName());
                e.setActivityStatus(u.getActivityStatus());
                e.setActivityStatusReamrkName(u.getActivityStatusReamrkName());
                e.setActivityStatusRemark(u.getActivityStatusRemark());
                e.setPersonalSynopsis(u.getPersonalSynopsis());
                e.setRole(u.getRole());
                e.setSpeechTopic(u.getSpeechTopic());
                // 用车信息
                e.setcAccompanyLeader(u.getcAccompanyLeader());
                e.setcAddRemark(u.getcAddRemark());
                e.setCarEnd(u.getCarEnd());
                e.setCarEndRemark(u.getCarEndRemark());
                e.setCarEndRemarkName(u.getCarEndRemarkName());
                e.setcArrangeRemark(u.getcArrangeRemark());
                e.setCarStatus(u.getCarStatus());
                e.setCarStatusReamrkName(u.getCarStatusReamrkName());
                e.setCarStatusRemark(u.getCarStatusRemark());
                e.setcCarArrange(u.getcCarArrange());
                e.setcCarCard(u.getcCarCard());
                e.setcCarSType(u.getcCarSType());
                e.setcCarType(u.getcCarType());
                e.setcDestination(u.getcDestination());
                e.setcDriver(u.getcDriver());
                e.setcDriverPhone(u.getcDriverPhone());
                e.setcHasStopCard(u.getcHasStopCard());
                e.setcPayType(u.getcPayType());
                e.setcRidePeoples(u.getcRidePeoples());
                e.setcRidePlace(u.getcRidePlace());
                e.setcUseCarDate(u.getcUseCarDate());
                e.setcUseCarTime(u.getcUseCarTime());
                e.setjAccompanyLeader(u.getjAccompanyLeader());
                e.setjAddRemark(u.getjAddRemark());
                e.setjArrangeRemark(u.getjArrangeRemark());
                e.setjCarArrange(u.getjCarArrange());
                e.setjCarCard(u.getjCarCard());
                e.setjCarSType(u.getjCarSType());
                e.setjCarType(u.getjCarType());
                e.setjDestination(u.getjDestination());
                e.setjDriver(u.getjDriver());
                e.setjDriverPhone(u.getjDriverPhone());
                e.setjHasStopCard(u.getjHasStopCard());
                e.setjPayType(u.getjPayType());
                e.setjRidePeoples(u.getjRidePeoples());
                e.setjRidePlace(u.getjRidePlace());
                e.setjTrafficNum(u.getjTrafficNum());
                e.setjUseCarDate(u.getjUseCarDate());
                e.setjUseCarTime(u.getjUseCarTime());
                e.setsAccompanyLeader(u.getsAccompanyLeader());
                e.setsAddRemark(u.getsAddRemark());
                e.setsArrangeRemark(u.getsArrangeRemark());
                e.setsCarArrange(u.getsCarArrange());
                e.setsCarCard(u.getsCarCard());
                e.setsCarSType(u.getsCarSType());
                e.setsCarType(u.getsCarType());
                e.setsDestination(u.getsDestination());
                e.setsDriver(u.getsDriver());
                e.setsDriverPhone(u.getsDriverPhone());
                e.setsHasStopCard(u.getsHasStopCard());
                e.setsPayType(u.getsPayType());
                e.setsRidePeoples(u.getsRidePeoples());
                e.setsRidePlace(u.getsRidePlace());
                e.setsTrafficNum(u.getsTrafficNum());
                e.setsUseCarDate(u.getsUseCarDate());
                e.setsUseCarTime(u.getsUseCarTime());
                // 用餐信息
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
                // 住房信息
                e.setHotelName(u.getHotelName());
                e.setHotelRoomNum(u.getHotelRoomNum());
                e.setHotelRoomType(u.getHotelRoomType());
                e.setHotelVacant(u.getHotelVacant());
                e.setHouseAddRemark(u.getHouseAddRemark());
                e.setHouseArrange(u.getHouseArrange());
                e.setHouseArrangeRemark(u.getHouseArrangeRemark());
                e.setHouseEnd(u.getHouseEnd());
                e.setHouseEndRemark(u.getHouseEndRemark());
                e.setHouseEndRemarkName(u.getHouseEndRemarkName());
                e.setHouseInDate(u.getHouseInDate());
                e.setHouseOutDate(u.getHouseOutDate());
                e.setHousePayType(u.getHousePayType());
                e.setHouseStatus(u.getHouseStatus());
                e.setHouseStatusReamrkName(u.getHouseStatusReamrkName());
                e.setHouseStatusRemark(u.getHouseStatusRemark());
                e.setPrice(u.getPrice());
                e.setRoomTotal(u.getRoomTotal());
                e.setSplicePeople(u.getSplicePeople());
                e.setSpliceRoom(u.getSpliceRoom());
                e.setTotalPrice(u.getTotalPrice());
                ues.add(e);
            }
        }
        ExcelUtils.writeExcel(response, ues, UserExcel.class, "客户个人信息表");
    }

    /**
     * 导入页面
     *
     * @return
     */
    @RequestMapping(value = "/include_html")
    public String include_html() {
        return PREFIX + "tUser_include.html";
    }

    /**
     * 所有信息导入功能.
     *
     * @return
     */
    @RequestMapping(value = "/include")
    @ResponseBody
    public Object include(MultipartFile file) {
        List<TNewUser> usersExcels = ExcelUtils.readExcel("", TNewUser.class, file);
        for (TNewUser userExcel : usersExcels) {
        	
        	userExcel.setHouseInDate(DateUtil.format(new Date(userExcel.getHouseInDate()), "yyyy-MM-dd hh:mm:ss"));
        	userExcel.setHouseOutDate(DateUtil.format(new Date(userExcel.getHouseOutDate()), "yyyy-MM-dd hh:mm:ss"));
        	
        	userExcel.setjUseCarDate(DateUtil.format(new Date(userExcel.getjUseCarDate()), "yyyy-MM-dd"));
        	userExcel.setjUseCarTime(DateUtil.format(new Date(userExcel.getjUseCarTime()), "hh:mm:ss"));
        	
        	userExcel.setsUseCarDate(DateUtil.format(new Date(userExcel.getsUseCarDate()), "yyyy-MM-dd"));
        	userExcel.setsUseCarTime(DateUtil.format(new Date(userExcel.getsUseCarTime()), "hh:mm:ss"));
        	
        	userExcel.setcUseCarDate(DateUtil.format(new Date(userExcel.getcUseCarDate()), "yyyy-MM-dd"));
        	userExcel.setcUseCarTime(DateUtil.format(new Date(userExcel.getcUseCarTime()), "hh:mm:ss"));
        	
            userExcel.setCreateTime(DateUtil.getTime());
            userExcel.setCreateBy(ShiroKit.getUser().getId());
            // 接车信息
            userExcel.setjCarArrange(0);
            // 送车信息
            userExcel.setsCarArrange(0);
            // 市内用车信息
            userExcel.setcCarArrange(0);
            // 用车公共基础信息
            userExcel.setCarStatus(0);
            userExcel.setCarEnd(0);
            // 用餐信息
            userExcel.setEatStatus(0);
            userExcel.setEatEnd(0);
            userExcel.setEatArrange(0);
            // 住房信息
            userExcel.setHouseStatus(0);
            userExcel.setHouseEnd(0);
            userExcel.setHouseArrange(0);
            // 活动信息
            userExcel.setActivityStatus(0);
            this.iNewUserService.insert(userExcel);
        }
        return SUCCESS_TIP;
    }

    @RequestMapping("/findConpanyName")
    @ResponseBody
    public String findConpanyName(String cp) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", cp);
        List<TNewUser> users = this.iNewUserService.selectByMap(params);
        if (users != null && users.size() > 0) {
            return "ok";
        }
        return "no";
    }
}
