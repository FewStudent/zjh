package com.stylefeng.guns.modular.system.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.enums.CardType;
import com.stylefeng.guns.core.log.LogObjectHolder;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.core.util.DateUtil;
import com.stylefeng.guns.modular.system.excel.TeamExcel;
import com.stylefeng.guns.modular.system.model.TFile;
import com.stylefeng.guns.modular.system.model.TNewTeam;
import com.stylefeng.guns.modular.system.model.User;
import com.stylefeng.guns.modular.system.service.ITFileService;
import com.stylefeng.guns.modular.system.service.ITNewTeamService;
import com.stylefeng.guns.modular.system.service.IUserService;
import com.stylefeng.guns.modular.system.util.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * 控制器
 *
 * @author fengshuonan
 * @Date 2019-09-19 19:02:40
 */
@Controller
@RequestMapping("/tTeam")
public class TTeamController extends BaseController {

    private String PREFIX = "/system/tTeam/";

    @Autowired
    private IUserService iUserService;
    @Autowired
    private ITNewTeamService itNewTeamService;
    @Autowired
    private ITFileService fileService;

    /**
     * 跳转到首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "tTeam.html";
    }

    /**
     * 跳转到添加
     */
    @RequestMapping("/tTeam_add")
    public String tTeamAdd() {
        return PREFIX + "tTeam_add.html";
    }

    /**
     * 跳转到修改
     */
    @RequestMapping("/tTeam_update/{tTeamId}")
    public String tTeamUpdate(@PathVariable Integer tTeamId, Model model) {
        TNewTeam tTeam = itNewTeamService.queryTeamInfoById(tTeamId);
        // 演讲材料文件
        String sfile = tTeam.getSpeechFile();
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
        String photo = tTeam.getPhotoFile();
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
        model.addAttribute("item", tTeam);
        LogObjectHolder.me().set(tTeam);
        return PREFIX + "tTeam_edit.html";
    }

    /**
     * 跳转到详情
     */
    @RequestMapping("/tTeam_detail/{tTeamId}")
    public String tTeamDetail(@PathVariable Integer tTeamId, Model model) {
        TNewTeam tTeam = itNewTeamService.queryTeamInfoById(tTeamId);
        // 演讲材料文件
        String sfile = tTeam.getSpeechFile();
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
        String photo = tTeam.getPhotoFile();
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
        model.addAttribute("item", tTeam);
        LogObjectHolder.me().set(tTeam);
        return PREFIX + "tTeam_detail.html";
    }

    /**
     * 跳转到用餐添加
     *
     * @param tTeamId
     * @param model
     * @return
     */
    @RequestMapping("/eat_add/{tTeamId}")
    public String tUserEatAdd(@PathVariable Integer tTeamId, Model model) {
        model.addAttribute("teamId", tTeamId);
        return PREFIX + "tTeamEat_add.html";
    }

    /**
     * 跳转到用车添加
     *
     * @param tTeamId
     * @param model
     * @return
     */
    @RequestMapping("/car_add/{tTeamId}")
    public String tUserCarAdd(@PathVariable Integer tTeamId, Model model) {
        model.addAttribute("teamId", tTeamId);
        return PREFIX + "tTeamCar_add.html";
    }

    /**
     * 跳转到住房添加
     *
     * @param tTeamId
     * @param model
     * @return
     */
    @RequestMapping("/house_add/{tTeamId}")
    public String tUserHouseAdd(@PathVariable Integer tTeamId, Model model) {
        model.addAttribute("teamId", tTeamId);
        return PREFIX + "tTeamHouse_add.html";
    }

    /**
     * 跳转到档案添加
     * @param tTeamId
     * @param model
     * @return
     */
    @RequestMapping("/archive_add/{tTeamId}")
    public String tUserArchiveAdd(@PathVariable Integer tTeamId, Model model) {
        model.addAttribute("teamId", tTeamId);
        return PREFIX + "tTeamArchives_add.html";
    }

    /**
     * 获取列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String filed1, String value1, String filed2, String value2) {
        // 判断是否是录入员，如果是录入员 只能看到自己录入的信息
        List<TNewTeam> teams;
        
        if (!ShiroKit.getUser().getRoleList().contains(6)) {
            teams = itNewTeamService.queryTeamInfoByFiled(filed1, value1, filed2, value2, null);
        } else {
            teams = itNewTeamService.queryTeamInfoByFiled(filed1, value1, filed2, value2, ShiroKit.getUser().getId());
        }
        for (TNewTeam tTeam : teams) {
            //设置证件类型名称
            tTeam.setCertificatesName(CardType.getTypeByIndex(tTeam.getCard()));
        }
        return teams;
    }

    /**
     * 新增
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(TNewTeam tTeam, String sfile, String imgfile) {
        tTeam.setCreateTime(DateUtil.getTime());
        tTeam.setCreateBy(ShiroKit.getUser().getId());
        tTeam.setSpeechFile(sfile);
        tTeam.setPhotoFile(imgfile);
        itNewTeamService.insert(tTeam);
        return SUCCESS_TIP;
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer tTeamId) {
        itNewTeamService.deleteById(tTeamId);
        // 删除关联的用车 用餐 住房 档案等信息
        return SUCCESS_TIP;
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(TNewTeam tTeam, String sfile, String imgfile) {
        TNewTeam ot = new TNewTeam();
        tTeam.setUpdateTime(DateUtil.getTime());
        if (sfile != null && !sfile.equals("")) {
            String osfile = ot.getSpeechFile();
            if (osfile != null && !osfile.equals("")) {
                if (osfile.substring(osfile.length() - 1).equals(",")) {
                    tTeam.setSpeechFile(osfile + sfile);
                } else {
                    tTeam.setSpeechFile(osfile + "," + sfile);
                }
            } else {
                tTeam.setSpeechFile(sfile);
            }

        }
        if (imgfile != null && !imgfile.equals("")) {
            String opfile = ot.getPhotoFile();
            if (opfile != null && !opfile.equals("")) {
                if (opfile.substring(opfile.length() - 1).equals(",")) {
                    tTeam.setPhotoFile(opfile + imgfile);
                } else {
                    tTeam.setPhotoFile(opfile + "," + imgfile);
                }
            } else {
                tTeam.setPhotoFile(imgfile);
            }
        }
        itNewTeamService.updateById(tTeam);
        return SUCCESS_TIP;
    }

    /**
     * 详情
     */
    @RequestMapping(value = "/detail/{tTeamId}")
    @ResponseBody
    public Object detail(@PathVariable("tTeamId") Integer tTeamId) {
        return itNewTeamService.queryTeamInfoById(tTeamId);
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
        String roleid = user.getRoleid();
        List<TNewTeam> newTeams = new ArrayList<>();
        if (roleid.contains("6")) {
            Map<String, Object> params = new HashMap<>();
            params.put("create_by", adminId);
            newTeams = this.itNewTeamService.selectByMap(params);
        } else {
            newTeams = this.itNewTeamService.selectList(null);
        }
        List<TeamExcel> tes = new ArrayList<>();
        if (newTeams != null) {
            for (TNewTeam u : newTeams) {
                TeamExcel e = new TeamExcel();
                // 基础信息
                e.setCompany(u.getCompany());
                e.setArea(u.getArea());
                e.setCompanyLeader(u.getCompanyLeader());
                e.setTeamNums(u.getTeamNums());
                e.setCard(u.getCard());
                e.setLinkUser(u.getLinkUser());
                e.setLinkPhone(u.getLinkPhone());
                e.setPickUp(u.getPickUp());
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
                tes.add(e);
            }
        }
        ExcelUtils.writeExcel(response, tes, TeamExcel.class, "客户团体信息表");
    }

    @RequestMapping(value = "/include_html")
    public String include_html() {
        return PREFIX + "tTeam_include.html";
    }

    /**
     * 导入
     *
     * @return
     */
    @RequestMapping(value = "/include")
    @ResponseBody
    public Object include(MultipartFile file) {
        List<TNewTeam> teamExcelIncludes = ExcelUtils.readExcel("", TNewTeam.class, file);
        for (TNewTeam teamExcel : teamExcelIncludes) {

            teamExcel.setHouseInDate(DateUtil.format(new Date(teamExcel.getHouseInDate()), "yyyy-MM-dd hh:mm:ss"));
            teamExcel.setHouseOutDate(DateUtil.format(new Date(teamExcel.getHouseOutDate()), "yyyy-MM-dd hh:mm:ss"));

            teamExcel.setjUseCarDate(DateUtil.format(new Date(teamExcel.getjUseCarDate()), "yyyy-MM-dd"));
            teamExcel.setjUseCarTime(DateUtil.format(new Date(teamExcel.getjUseCarTime()), "hh:mm:ss"));

            teamExcel.setsUseCarDate(DateUtil.format(new Date(teamExcel.getsUseCarDate()), "yyyy-MM-dd"));
            teamExcel.setsUseCarTime(DateUtil.format(new Date(teamExcel.getsUseCarTime()), "hh:mm:ss"));

            teamExcel.setcUseCarDate(DateUtil.format(new Date(teamExcel.getcUseCarDate()), "yyyy-MM-dd"));
            teamExcel.setcUseCarTime(DateUtil.format(new Date(teamExcel.getcUseCarTime()), "hh:mm:ss"));
            
            teamExcel.setCreateTime(DateUtil.getTime());
            teamExcel.setCreateBy(ShiroKit.getUser().getId());
            //用车信息
            teamExcel.setjCarArrange(0);
            //送车信息
            teamExcel.setsCarArrange(0);
            // 市内用车信息
            teamExcel.setcCarArrange(0);
            // 用车公共基础信息
            teamExcel.setCarStatus(0);
            teamExcel.setCarEnd(0);
            //用餐信息
            teamExcel.setEatStatus(0);
            teamExcel.setEatEnd(0);
            teamExcel.setEatArrange(0);
            // 住房信息
            teamExcel.setHouseStatus(0);
            teamExcel.setHouseEnd(0);
            teamExcel.setHouseArrange(0);
            // 活动信息
            teamExcel.setActivityStatus(0);
            this.itNewTeamService.insert(teamExcel);
        }
        return SUCCESS_TIP;
    }

    @RequestMapping("/findConpanyName")
    @ResponseBody
    public String findConpanyName(String cp) {
        Map<String, Object> params = new HashMap<>();
        params.put("company", cp);
        List<TNewTeam> teams = this.itNewTeamService.selectByMap(params);
        if (teams != null && teams.size() > 0) {
            return "ok";
        }
        return "no";
    }
}
