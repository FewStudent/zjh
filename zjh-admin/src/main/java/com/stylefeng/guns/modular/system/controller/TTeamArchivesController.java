package com.stylefeng.guns.modular.system.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.enums.RoleType;
import com.stylefeng.guns.core.enums.VerifyType;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.core.util.DateUtil;
import com.stylefeng.guns.modular.system.excel.TeamActivityExcel;
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

import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * 控制器
 *
 * @author fengshuonan
 * @Date 2019-09-19 19:02:46
 */
@Controller
@RequestMapping("/tTeamArchives")
public class TTeamArchivesController extends BaseController {

    private String PREFIX = "/system/tTeamArchives/";
    @Autowired
    private ITTeamArchivesService tTeamArchivesService;
    @Autowired
    private ITFileService fileService;
    @Autowired
    private IUserService userService;
    @Autowired
    private ITNewTeamService service;

    /**
     * 跳转到首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "tTeamArchives.html";
    }

    /**
     * 跳转到添加
     */
    @RequestMapping("/tTeamArchives_add")
    public String tTeamAdd() {
        return PREFIX + "tTeamArchives_add.html";
    }

    /**
     * 跳转到修改
     */
    @RequestMapping("/tTeamArchives_update/{tTeamArchivesId}")
    public String tTeamArchivesUpdate(@PathVariable Integer tTeamArchivesId, Model model) {
        TNewTeam archive = service.queryTeamActivityById(tTeamArchivesId);
        // 演讲材料文件
        String sfile = archive.getSpeechFile();
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
        String photo = archive.getPhotoFile();
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
        model.addAttribute("item", archive);
        LogObjectHolder.me().set(archive);
        return PREFIX + "tTeamArchives_edit.html";
    }

    /**
     * 跳转到详情
     */
    @RequestMapping("/tTeamArchives_detail/{tTeamArchivesId}")
    public String tTeamArchivesDetail(@PathVariable Integer tTeamArchivesId, Model model) {
        TNewTeam archive = service.queryTeamActivityById(tTeamArchivesId);
        archive.setActivityStatusName(VerifyType.getTypeByIndex(archive.getActivityStatus()));
        // 演讲材料文件
        String sfile = archive.getSpeechFile();
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
        String photo = archive.getPhotoFile();
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
        model.addAttribute("item", archive);
        LogObjectHolder.me().set(archive);
        return PREFIX + "tTeamArchives_detail.html";
    }

    /**
     * 跳转到审核页面
     *
     * @param tTeamArchivesId
     * @return
     */
    @RequestMapping(value = "/examine/{tTeamArchivesId}")
    public String examine_html(@PathVariable("tTeamArchivesId") Integer tTeamArchivesId, Model model) {
        model.addAttribute("id", tTeamArchivesId);
        model.addAttribute("item", service.queryTeamActivityById(tTeamArchivesId));
        return PREFIX + "tTeamArchives_examine.html";
    }

    /**
     * 获取列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(Integer status, String filed1,String filed2,String value1,String value2) {
        if (status != null && status.intValue() == -1) {
            status = null;
        }
        // 判断是否是录入员，如果是录入员 只能看到自己录入的信息
        List<TNewTeam> archives;
        if(ShiroKit.getUser().getRoleList().contains(1) || ShiroKit.getUser().getRoleList().contains(10)){
            archives = service.queryTeamActivityByFiled(filed1, value1, filed2, value2, status, null);
        }else {
            archives = service.queryTeamActivityByFiled(filed1, value1, filed2, value2, status, ShiroKit.getUser().getId());
        }
        for (TNewTeam archive : archives) {
            // 审核状态
            archive.setActivityStatusName(VerifyType.getTypeByIndex(archive.getActivityStatus()));
            archive.setRoleName(RoleType.getTypeByIndex(archive.getRole()));
        }
        return archives;
    }

    /**
     * 新增
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(TTeamArchives tTeamArchives, String sfile, String imgfile) {
        tTeamArchives.setCreateTime(DateUtil.getTime());
        tTeamArchives.setStatus(0);
        tTeamArchives.setSpeechFile(sfile);
        tTeamArchives.setPhoneFile(imgfile);
        tTeamArchivesService.insert(tTeamArchives);
        return SUCCESS_TIP;
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer tTeamArchivesId) {
        service.deleteById(tTeamArchivesId);
        return SUCCESS_TIP;
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(TNewTeam tTeamArchives, String sfile, String imgfile) {
        TNewTeam ot = this.service.selectById(tTeamArchives.getId());
        tTeamArchives.setUpdateTime(DateUtil.getTime());
        if (sfile != null && !sfile.equals("")) {
            String osfile = ot.getSpeechFile();
            if (osfile != null && !osfile.equals("")) {
                if (osfile.substring(osfile.length() - 1).equals(",")) {
                    tTeamArchives.setSpeechFile(osfile + sfile);
                } else {
                    tTeamArchives.setSpeechFile(osfile + "," + sfile);
                }
            } else {
                tTeamArchives.setSpeechFile(sfile);
            }

        }
        if (imgfile != null && !imgfile.equals("")) {
            String opfile = ot.getPhotoFile();
            if (opfile != null && !opfile.equals("")) {
                if (opfile.substring(opfile.length() - 1).equals(",")) {
                    tTeamArchives.setPhotoFile(opfile + imgfile);
                } else {
                    tTeamArchives.setPhotoFile(opfile + "," + imgfile);
                }
            } else {
                tTeamArchives.setPhotoFile(imgfile);
            }
        }
        service.updateById(tTeamArchives);
        return SUCCESS_TIP;
    }

    /**
     * 详情
     */
    @RequestMapping(value = "/detail/{tTeamArchivesId}")
    @ResponseBody
    public Object detail(@PathVariable("tTeamArchivesId") Integer tTeamArchivesId) {
        return service.selectById(tTeamArchivesId);
    }

    @RequestMapping("/examine_do")
    @ResponseBody
    public Object examine_do(Integer id, Integer status, String sRemarkName, String sRemarkContent) {
        TNewTeam archive = this.service.queryTeamActivityById(id);
        archive.setActivityStatus(status);
        archive.setActivityStatusReamrkName(sRemarkName);
        archive.setActivityStatusRemark(sRemarkContent);
        this.service.updateById(archive);
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
        List<TNewTeam> teams = new ArrayList<>();
        if (roleid.contains("6")) {
            Map<String, Object> params = new HashMap<>();
            params.put("create_by", adminId);
            teams = this.service.selectByMap(params);
        }else {
            teams = this.service.selectList(null);
        }
        List<TeamActivityExcel> uas = new ArrayList<>();
        if (teams != null) {
            for (TNewTeam u : teams) {
                TeamActivityExcel ua = new TeamActivityExcel();
                ua.setCompany(u.getCompany());
                ua.setArea(u.getArea());
                ua.setCard(u.getCard());
                ua.setCompanyLeader(u.getCompanyLeader());
                ua.setCreateTime(u.getCreateTime());
                ua.setUpdateTime(u.getUpdateTime());
                ua.setPickUp(u.getPickUp());
                ua.setTeamNums(u.getTeamNums());
                ua.setLinkUser(u.getLinkUser());
                ua.setLinkPhone(u.getLinkPhone());

                ua.setAccount(u.getAccount());
                ua.setAccountBlank(u.getAccountBlank());
                ua.setAccountName(u.getAccountName());
                ua.setActivity(u.getActivity());
                ua.setActivityAddRemark(u.getActivityAddRemark());
                ua.setActivityAddRemarkName(u.getActivityAddRemarkName());
                ua.setActivityStatus(u.getActivityStatus());
                ua.setActivityStatusReamrkName(u.getActivityStatusReamrkName());
                ua.setActivityStatusRemark(u.getActivityStatusRemark());
                ua.setPersonalSynopsis(u.getPersonalSynopsis());
                ua.setRole(u.getRole());
                ua.setSpeechTopic(u.getSpeechTopic());
                uas.add(ua);
            }
        }
        ExcelUtils.writeExcel(response, uas, TeamActivityExcel.class, "客户团体活动表");
    }


    @RequestMapping(value = "/delete_sfile")
    @ResponseBody
    public String delete_sfile(Integer fileid, Integer aid) {
        TTeamArchives archives = this.tTeamArchivesService.selectById(aid);
        String sfile = archives.getSpeechFile();
        if (sfile != null) {
            String sf = "";
            String[] sfileArr = sfile.split(",");
            for (String str : sfileArr) {
                if (Integer.valueOf(str).intValue() != fileid.intValue()) {
                    sf = sf + str + ",";
                }
            }
            archives.setSpeechFile(sf);
            this.tTeamArchivesService.updateById(archives);
            this.fileService.deleteById(fileid);
            return "success";
        }
        return "error";
    }

    @RequestMapping(value = "/delete_pfile")
    @ResponseBody
    public String delete_pfile(Integer fileid, Integer aid) {
        TTeamArchives archives = this.tTeamArchivesService.selectById(aid);
        String pfile = archives.getPhoneFile();
        if (pfile != null) {
            String sf = "";
            String[] pfileArr = pfile.split(",");
            for (String str : pfileArr) {
                if (Integer.valueOf(str).intValue() != fileid.intValue()) {
                    sf = sf + str + ",";
                }
            }
            archives.setPhoneFile(sf);
            this.tTeamArchivesService.updateById(archives);
            this.fileService.deleteById(fileid);
            return "success";
        }
        return "error";
    }


}
